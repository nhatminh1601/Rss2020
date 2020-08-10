package com.example.rss.xml;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rss.adapter.ChannelAdapter;
import com.example.rss.interfaces.OnItemClickListener;
import com.example.rss.object.News;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ReadXml extends AsyncTask<Void, Void, Void> {

    Context context;
    News news;
    ArrayList<News> listData;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    URL url;
    String address;

    public ReadXml(Context context, News news, RecyclerView recyclerView) {
        this.context = context;
        this.news = news;
        this.recyclerView = recyclerView;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        address = news.getUrl();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        ChannelAdapter channelAdapter = new ChannelAdapter(listData, (OnItemClickListener) context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(channelAdapter);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        ProcessXml(GetXml());
        return null;
    }

    private void ProcessXml(Document data) {
        if (data != null) {
            listData = new ArrayList<>();
            Element root = data.getDocumentElement();
            NodeList itemNodes = root.getElementsByTagName("item");
            for (int i = 0; i < itemNodes.getLength(); i++) {
                listData.add(dissectItemNode(itemNodes, i));
            }

        }
    }

    private News dissectItemNode(NodeList nodeList, int i) {
        try {
            Element entry = (Element) nodeList.item(i);
            Element title = (Element) entry.getElementsByTagName("title").item(0);
            Element description = (Element) entry.getElementsByTagName("description").item(0);
            Element pubDate = (Element) entry.getElementsByTagName("pubDate").item(0);
            Element link = (Element) entry.getElementsByTagName("link").item(0);
            String titleValue = title.getFirstChild().getNodeValue();
            String descriptionValue = description.getFirstChild().getNodeValue();
            String dateValue = pubDate.getFirstChild().getNodeValue();
            String linkValue = link.getFirstChild().getNodeValue();
            News item=new News(i,titleValue,descriptionValue,linkValue,null);
            return item;
        } catch (DOMException e) {
            Log.d("err", "dissectItemNode: " + e.getMessage());
            return null;
        }
    }

    private Document GetXml() {
        try {
            url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDoc = builder.parse(inputStream);
            return xmlDoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
