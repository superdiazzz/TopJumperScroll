# TopJumperScroll 
Make Your Fab responsive by your touch :D
<a href="https://bintray.com/superdiazzz/TopJumperScroll/TopJumperScroll/1.1.0/link"><img src="https://api.bintray.com/packages/superdiazzz/TopJumperScroll/TopJumperScroll/images/download.svg?version=1.1.0"/></a>

## Installation

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

```bash
implementation 'com.zulhijananda.jumperscroll:TopJumperScroll:1.1.0'
```

This module stands on java 8. So, do not forget to use java 1.8 to your build.gradle app 
```bash
android {
    ———
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
————
}
```
## Usage
In your Activity/fragment call main objects (JumperScrollView and JumperFab) like below
```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JumperScrollView jumperScrollView = findViewById(R.id.scrollv);
        JumperFab jumperFab = findViewById(R.id.jumperFab);

        new JumperObject.Builder(this)
                .setJumperScrollView(jumperScrollView)
                .setJumperFab(jumperFab)
                .setSpeedScroll(2000)
                .build();
 }
```   
And your layout might like this

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.design.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <zulhijananda.com.jumperscrollview.JumperScrollView
        android:id="@+id/scrollv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:id="@+id/content"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/large_text"/>
    </zulhijananda.com.jumperscrollview.JumperScrollView>

    <zulhijananda.com.jumperscrollview.JumperFab
        android:id="@+id/jumperFab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_anchor="@id/scrollv"
        app:layout_anchorGravity="right|bottom"
        android:src="@drawable/ic_vertical_align_top_black_24dp" />

</android.support.design.widget.CoordinatorLayout>
```
## And Result will be
<a href="https://gifyu.com/image/Elfa"><img src="https://s3.gifyu.com/images/JumperScroll.md.gif" alt="JumperScroll.gif" border="0" /></a>

If you use AppBar with CollapsingToolbarLayout, you can connecting it with this module like below
```java
new JumperObject.Builder(this)
  .setJumperScrollView(jumperScrollView)
  .setJumperFab(jumperFab)
  .setAppBarLayout(appBarLayout) // after instance your appbar then put it here!
  .setSpeedScroll(2000)
  .build();
  ```
  
## Lisense
[Apache 2.0](http://www.opensource.org/licenses/apache2.0.php)
