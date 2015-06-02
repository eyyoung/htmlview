package com.nd.android.sdp.im.common.widget.htmlview.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.nd.android.sdp.im.common.widget.htmlview.view.HtmlView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.Objects;


public class MainActivity extends ActionBarActivity {


    private ListView mLvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLvMain = (ListView) findViewById(R.id.lvMain);
        mLvMain.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 20;
            }

            @Override
            public Object getItem(int position) {
                return new Object();
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = new HtmlView(MainActivity.this);
                }
                HtmlView htmlView = (HtmlView) convertView;
                htmlView.loadHtml("<div style=\"border:5px solid green;background-color:yellow;padding:5px;float:right\">\n" +
                        "float:right with<br>green border</div>\n" +
                        "\n" +
                        "<h1>HtmlView Demo</h1>\n" +
                        "\n" +
                        "<p>The links below are annotated with target='_htmlview' to stay in the html view.\n" +
                        "Other links will trigger a web intent by default. This behavior can easily\n" +
                        "be changed by overriding the corresponding method in <tt>DefaultRequestHandler</tt>.</p>\n" +
                        "\n" +
                        "<ul>\n" +
                        "<li><a href=\"http://www.uow.edu.au/~nabg/WebServer/HTMLnJavascript/HTML2.html\" \n" +
                        "       target=\"_htmlview\">HTML Sample</a></li>\n" +
                        "<li><a href=\"input.html\">Input and Table Samples</a></li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor\n" +
                        "incidunt ut labore et dolore magna aliqua.\n" +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut\n" +
                        "aliquid ex ea commodi consequat.</p>\n" +
                        "\n" +
                        "<hr>\n" +
                        "\n" +
                        "<button>The End.</button>" +
                        "<div><img width=\"350\" height=\"240\" src=\"http://ww3.sinaimg.cn/bmiddle/6e690447gw1es9kuw9qtbj20c9083my5.jpg\"/></div>" +
                        "<include layout=\"@layout/clock\"></include>");
                return convertView;
            }
        });
    }

    public void test(View v) {
        Toast.makeText(this, "TEST", Toast.LENGTH_SHORT).show();
    }

}
