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
