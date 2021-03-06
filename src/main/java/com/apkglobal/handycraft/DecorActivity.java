package com.apkglobal.handycraft;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DecorActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        CardAdapter cardAdapter=new CardAdapter();

        recyclerView.setAdapter(cardAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class CardAdapter extends RecyclerView.Adapter<MeraHolder>  {
        List<data> dataArrayList;

        public CardAdapter()
        {
            super();
            dataArrayList=new ArrayList<data>();
            data data=new data();
            data.setName("Basket");
            data.setImage(R.drawable.db1);
            data.setPrice("199 Rs.");
            dataArrayList.add(data);

            data=new data();
            data.setName("Basket1");
            data.setImage(R.drawable.db2);
            data.setPrice("199 Rs.");
            dataArrayList.add(data);

            data=new data();
            data.setName("Teddy Basket");
            data.setImage(R.drawable.d3);
            data.setPrice("329 Rs.");
            dataArrayList.add(data);

            data=new data();
            data.setName("Basket2");
            data.setImage(R.drawable.d4);
            data.setPrice("199 Rs.");
            dataArrayList.add(data);

            data=new data();
            data.setName("Frames");
            data.setImage(R.drawable.dimg);
            data.setPrice("549 Rs.");
            dataArrayList.add(data);



/*
            data=new data();
            data.setName("Jhumka");
            data.setImage(R.drawable.zoom);
            dataArrayList.add(data);
*/

        }

        @Override
        public MeraHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
            //false is taken to add dynamic data at complie time
            MeraHolder meraHolder=new MeraHolder(view);
            return meraHolder;
            //return null;
        }

        @Override
        public void onBindViewHolder(MeraHolder holder, int position) {

            data data=dataArrayList.get(position);
            holder.imageView.setImageResource(data.getImage());
            holder.textView.setText(data.getName());
            holder.textview1.setText(data.getPrice());


        }

        @Override
        public int getItemCount() {
            return dataArrayList.size();
        }
    }

    private class MeraHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView,textview1;
        public MeraHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.iv_icon);
            textView=(TextView)itemView.findViewById(R.id.tv_name);
            textview1=(TextView)itemView.findViewById(R.id.tv_price);
        }
    }
}
