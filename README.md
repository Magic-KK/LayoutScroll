# LayoutScroll
仿淘宝垂直滚动器 上下跑马灯自动滚动

### 怎样使用

#### 1、添加全局依赖<br>

```
    allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```


##### 2、添加app依赖

```
    dependencies {
	         compile 'com.github.zhangkexpz:LayoutScroll:v1.0'
	}
```

#### 2、布局中添加 EasyLayoutScroll <br>

**xml文件**

```xml
 <com.layoutscroll.layoutscrollcontrols.view.EasyLayoutScroll
        android:id="@+id/upview1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="10dp"
        app:duration="2000"
        app:gradient="true"
        app:interval="1000"></com.layoutscroll.layoutscrollcontrols.view.EasyLayoutScroll>

```

**Attributes:**

|attr属性|description 描述|default vuale 默认值|
|:---|:---|:---|
|gradient|是否显示淡入淡出动画|默认true|
|interval|切换间隔|默认1000毫秒|
|duration|动画时间|默认2000毫秒|

#### 3、方法<br>

```java
public class MainActivity extends AppCompatActivity {

    EasyLayoutScroll easylayoutscroll;


    List<String> data;
    List<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easylayoutscroll = (EasyLayoutScroll) findViewById(R.id.upview1);
        initdata();
        setViews();
    }


    /**
     * 初始化数据
     */
    private void initdata() {
        data = new ArrayList<>();
        data.add("测试条目1");
        data.add("测试条目2");
        data.add("测试条目3");
        data.add("测试条目4");
    }

    /**
     * 添加布局
     */
    private void setViews() {
        for (int i = 0; i < data.size(); i++) {
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.item_view_single, null);
            TextView tv_title = moreView.findViewById(R.id.tv_title);
            tv_title.setText(data.get(i));
            views.add(moreView);
        }
        //设置数据集
        easylayoutscroll.setEasyViews(views);
        //开始滚动
        easylayoutscroll.startScroll();

        easylayoutscroll.setOnItemClickListener(new EasyLayoutListener.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                Toast.makeText(MainActivity.this, "您点击了第" + pos + "条索引", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (easylayoutscroll != null) {
            //停止滚动
            easylayoutscroll.stopScroll();
        }
    }
```

# Thanks
该项目参考了：

* [https://github.com/dreamlivemeng/UpMarqueeTextView-master](https://github.com/dreamlivemeng/UpMarqueeTextView-master)
* [https://github.com/sun-sky/Marquee](https://github.com/sun-sky/Marquee)
