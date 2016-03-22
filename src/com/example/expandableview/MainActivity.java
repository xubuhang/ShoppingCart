package com.example.expandableview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    private ExpandableListView expandableListView;

    private List<Shop> group_list;
    
    private List<List<Product>> item_list;

   

    private MyExpandableListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ���һ�Ѳ�������
        group_list = new ArrayList<Shop>();
        Shop shop1=new Shop();
        shop1.setShopName("�±�Ȫ�ٷ���Ȩ");
        shop1.setImage(R.drawable.group_img);
       
        Shop shop2=new Shop();
        shop2.setShopName("���෻�콢��");
        shop2.setImage(R.drawable.group_img);
        group_list.add(shop1);
        group_list.add(shop2);
      
        item_list = new ArrayList<List<Product>>();
        List<Product> item1= new ArrayList<Product>();
        Product product1=new Product();
        product1.setShopName("�±�Ȫ�ٷ���Ȩ1");
        product1.setImage(R.drawable.ic_launcher);
        product1.setProductName("��1��1 ��������ʿˬ��ˮ��ʪ��ˮ��������ë��... ");
    
        Product product2=new Product();
        product2.setShopName("�±�Ȫ�ٷ���Ȩ2");
        product2.setImage(R.drawable.ic_launcher);
        product2.setProductName("��1��1 ��������ʿˬ��ˮ��ʪ��ˮ��������ë��... ");
        item1.add(product1);
        item1.add(product2);
        item_list.add(item1);
        
        List<Product> item2= new ArrayList<Product>();
        Product product11=new Product();
        product11.setShopName("���෻�콢��1");
        product11.setImage(R.drawable.ic_launcher);
        product11.setProductName("��1��1 ��������ʿˬ��ˮ��ʪ��ˮ��������ë��... ");
    
        Product product22=new Product();
        product22.setShopName("���෻�콢��2");
        product22.setImage(R.drawable.ic_launcher);
        product22.setProductName("��1��1 ��������ʿˬ��ˮ��ʪ��ˮ��������ë��... ");
        item2.add(product11);
        item2.add(product22);
        item_list.add(item2);
        
        expandableListView = (ExpandableListView)findViewById(R.id.expendlist);
        expandableListView.setGroupIndicator(null);
      
        adapter = new MyExpandableListViewAdapter(this);

        expandableListView.setAdapter(adapter);
        
       //չ��ExpandableListView
        int groupCount = expandableListView.getCount();
        for (int i=0; i<groupCount; i++) {
             expandableListView.expandGroup(i);
          };
    }

    // �ù�ListView����һ������Ϥ��ֻ����������BaseExpandableListAdapter
    class MyExpandableListViewAdapter extends BaseExpandableListAdapter
    {

        private Context context;
        private GroupHolder groupHolder = null;
        private ItemHolder itemHolder = null;
        public MyExpandableListViewAdapter(Context context)
        {
            this.context = context;
        }

        /**
         *
         * ��ȡ��ĸ���
         *
         * @return
         * @see android.widget.ExpandableListAdapter#getGroupCount()
         */
        @Override
        public int getGroupCount()
        {
            return group_list.size();
        }

        /**
         *
         * ��ȡָ�����е���Ԫ�ظ���
         *
         * @param groupPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getChildrenCount(int)
         */
        @Override
        public int getChildrenCount(int groupPosition)
        {
            return item_list.get(groupPosition).size();
        }

        /**
         *
         * ��ȡָ�����е�����
         *
         * @param groupPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getGroup(int)
         */
        @Override
        public Object getGroup(int groupPosition)
        {
            return group_list.get(groupPosition);
        }

        /**
         *
         * ��ȡָ�����е�ָ����Ԫ�����ݡ�
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getChild(int, int)
         */
        @Override
        public Object getChild(int groupPosition, int childPosition)
        {
            return item_list.get(groupPosition).get(childPosition);
        }

        /**
         *
         * ��ȡָ�����ID�������ID������Ψһ��
         *
         * @param groupPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getGroupId(int)
         */
        @Override
        public long getGroupId(int groupPosition)
        {
            return groupPosition;
        }

        /**
         *
         * ��ȡָ�����е�ָ����Ԫ��ID
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see android.widget.ExpandableListAdapter#getChildId(int, int)
         */
        @Override
        public long getChildId(int groupPosition, int childPosition)
        {
            return childPosition;
        }

        /**
         *
         * �����Ԫ���Ƿ�����ȶ���ID,Ҳ���ǵײ����ݵĸı䲻��Ӱ�쵽���ǡ�
         *
         * @return
         * @see android.widget.ExpandableListAdapter#hasStableIds()
         */
        @Override
        public boolean hasStableIds()
        {
            return true;
        }

        /**
         *
         * ��ȡ��ʾָ�������ͼ����
         *
         * @param groupPosition ��λ��
         * @param isExpanded ������չ��״̬��������״̬
         * @param convertView �������е���ͼ����
         * @param parent ���ص���ͼ����ʼ�������ڵ���ͼ��
         * @return
         * @see android.widget.ExpandableListAdapter#getGroupView(int, boolean, android.view.View,
         *      android.view.ViewGroup)
         */
        @Override
        public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
        {
          
            if (convertView == null)
            {
                convertView = LayoutInflater.from(context).inflate(R.layout.expendlist_group, null);
                groupHolder = new GroupHolder();
                groupHolder.groupCheckBox = (CheckBox)convertView.findViewById(R.id.groupCheckBox);
                groupHolder.txt = (TextView)convertView.findViewById(R.id.txt);
                groupHolder.img = (ImageView)convertView.findViewById(R.id.img);
                convertView.setTag(groupHolder);
            }
            else
            {
                groupHolder = (GroupHolder)convertView.getTag();
            }

//            if (!isExpanded)
//            {
//                 groupHolder.img.setBackgroundResource(R.drawable.group_img);
//            }
//            else
//            {
//                 groupHolder.img.setBackgroundResource(R.drawable.group_open_two);
//            }

            groupHolder.txt.setText(group_list.get(groupPosition).getShopName());
            groupHolder.txt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(MainActivity.this, "���group�ı���", Toast.LENGTH_SHORT).show();
				}
			});
            if (group_list.get(groupPosition).isSecleted()) {
            	groupHolder.groupCheckBox.setChecked(true);
            }else {
            	groupHolder.groupCheckBox.setChecked(false);
            }
            groupHolder.groupCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(!buttonView.isPressed())return;	//���ֿ���Ϊ�����setChecked����һ����������setChecked()ʱ�ᴥ����listener 
					if (isChecked) {
						Toast.makeText(MainActivity.this, "���group��RadioButton��ѡ��", Toast.LENGTH_SHORT).show();
						group_list.get(groupPosition).setSecleted(true);
						for (int i = 0; i < item_list.get(groupPosition).size(); i++) {
						 item_list.get(groupPosition).get(i).setSecleted(true);
						}
					}else{
						Toast.makeText(MainActivity.this, "���group��RadioButton��ȡ��", Toast.LENGTH_SHORT).show();
						group_list.get(groupPosition).setSecleted(false);
						for (int i = 0; i < item_list.get(groupPosition).size(); i++) {
							 item_list.get(groupPosition).get(i).setSecleted(false);
							}
					}
					 notifyDataSetChanged();
				}
			});
            return convertView;
        }

        /**
         *
         * ��ȡһ����ͼ������ʾָ�����е�ָ����Ԫ�����ݡ�
         *
         * @param groupPosition ��λ��
         * @param childPosition ��Ԫ��λ��
         * @param isLastChild ��Ԫ���Ƿ������е����һ��
         * @param convertView �������е���ͼ(View)����
         * @param parent ���ص���ͼ(View)����ʼ�������ڵ���ͼ��
         * @return
         * @see android.widget.ExpandableListAdapter#getChildView(int, int, boolean, android.view.View,
         *      android.view.ViewGroup)
         */
        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
        {
          
            if (convertView == null)
            {
                convertView = LayoutInflater.from(context).inflate(R.layout.expendlist_item, null);
                itemHolder = new ItemHolder();
                itemHolder.itemCheckBox = (CheckBox)convertView.findViewById(R.id.itemCheckBox);
                itemHolder.txt = (TextView)convertView.findViewById(R.id.txt);
                itemHolder.img = (ImageView)convertView.findViewById(R.id.img);
                convertView.setTag(itemHolder);
            }
            else
            {
                itemHolder = (ItemHolder)convertView.getTag();
            }
            itemHolder.txt.setText(item_list.get(groupPosition).get(childPosition).getProductName());
            itemHolder.img.setBackgroundResource(item_list.get(groupPosition).get(childPosition).getImage());
            itemHolder.txt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(MainActivity.this, "���item�ı���", Toast.LENGTH_SHORT).show();
				}
			});
            if (item_list.get(groupPosition).get(childPosition).isSecleted()) {
            	itemHolder.itemCheckBox.setChecked(true);
            }else {
            	itemHolder.itemCheckBox.setChecked(false);
            }
            itemHolder.itemCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(!buttonView.isPressed())return;	//���ֿ���Ϊ�����setChecked����һ����������setChecked()ʱ�ᴥ����listener 
					if (isChecked) {
						Toast.makeText(MainActivity.this, "���item��RadioButton��ѡ��", Toast.LENGTH_SHORT).show();
						item_list.get(groupPosition).get(childPosition).setSecleted(true);
						boolean isAllSelected=true;
						for (int i = 0; i < item_list.get(groupPosition).size(); i++) {
							 if (!item_list.get(groupPosition).get(i).isSecleted()){
								 isAllSelected=false ;
								 return;}
							}
						if (isAllSelected) {
							group_list.get(groupPosition).setSecleted(true);
						}else {
							group_list.get(groupPosition).setSecleted(false);
						}
					}else{
						Toast.makeText(MainActivity.this, "���item��RadioButton��ȡ��", Toast.LENGTH_SHORT).show();
						item_list.get(groupPosition).get(childPosition).setSecleted(false);
						group_list.get(groupPosition).setSecleted(false);
					}
					notifyDataSetChanged();
				}
			});
            return convertView;
        }

        /**
         *
         * �Ƿ�ѡ��ָ��λ���ϵ���Ԫ�ء�
         *
         * @param groupPosition
         * @param childPosition
         * @return
         * @see android.widget.ExpandableListAdapter#isChildSelectable(int, int)
         */
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition)
        {
            return true;
        }

    }

    class GroupHolder
    {
    	 public CheckBox groupCheckBox;
    	 
        public TextView txt;

        public ImageView img;
    }

    class ItemHolder
    {
    	 public CheckBox itemCheckBox;
    	 
        public ImageView img;

        public TextView txt;
    }

}