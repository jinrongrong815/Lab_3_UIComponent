package com.example.jr.lab_3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.LayoutInflater;

import android.widget.TextView;
import android.widget.Toast;

public class SimpleAdapterActivity extends AppCompatActivity {

    private ListView listView;
    //private List<Entity> list;
    public int mCurrentItem=0;
    private String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] images = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter_layout);
        //初始化ListView控件
        listView = findViewById(R.id.listView);
        final MyBaseAdapator myBaseAdapator = new MyBaseAdapator();
        listView.setAdapter(myBaseAdapator);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                myBaseAdapator.notifyDataSetChanged();
                Toast.makeText(SimpleAdapterActivity.this,
                        names[position], Toast.LENGTH_LONG)
                        .show();
                mCurrentItem = position;
                myBaseAdapator.notifyDataSetChanged();

            }
        });

    }
    class MyBaseAdapator extends BaseAdapter{
        private LayoutInflater inflater;

        private int currentItem = -1;
        private boolean isClick=false;
        private int mSelect;   //选中项


        public void setCurrentItem(int currentItem){
            this.currentItem = currentItem;
        }
        @Override
        public int getCount(){
            return names.length;
        }
        @Override
        public Object getItem(int position){
            return names[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
             ViewHolder holder;   //final

            if (convertView == null) {
                convertView = LayoutInflater.from(getApplication()).inflate(R.layout.item_layout, parent, false);
                holder = new ViewHolder();
                holder.mTextView = convertView.findViewById(R.id.item_tv);
                holder.imageView = convertView.findViewById(R.id.item_img);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mTextView.setText(names[position]);
            holder.imageView.setBackgroundResource(images[position]);

            if(mCurrentItem == position){
                holder.mTextView.setEnabled(true);

            } else {
                listView.setBackgroundColor(Color.TRANSPARENT);
            }
            return convertView;
        }

        public void setClick(boolean click){
            this.isClick=click;
        }

        class ViewHolder {
            TextView mTextView;
            ImageView imageView;
        }
    }

}
