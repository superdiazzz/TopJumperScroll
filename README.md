# TopJumperScroll 
Make Your Fab responsive by your touch :D
<a href="https://bintray.com/superdiazzz/TopJumperScroll/TopJumperScroll/1.4.2/link"><img src="https://api.bintray.com/packages/superdiazzz/TopJumperScroll/TopJumperScroll/images/download.svg?version=1.4.2"/></a>

## Installation

```bash
implementation 'com.zulhijananda.jumperscroll:TopJumperScroll:1.x.x'
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
<a target="_blank" rel="noopener noreferrer" href="/demo/simple_fab.gif"><img src="/demo/simple_fab.gif" width="350" style="max-width:100%;"></a>

If you use AppBar with CollapsingToolbarLayout, you can connecting it with this module like below
```java
new JumperObject.Builder(this)
  .setJumperScrollView(jumperScrollView)
  .setJumperFab(jumperFab)
  .setAppBarLayout(appBarLayout) // after instance your appbar then put it here!
  .setSpeedScroll(2000)
  .build();
  ```
  
  If you want to use animation in your fab, you can do like below
  ![](demo/fabAnim.gif)
  
  and Code snippet like below
  ```java
  JumperObject.Builder(this)
            .setJumperScrollView(nested_scroll_view)
            .setJumperFab(jumperFab)
            .setAppBarLayout(appBarLayout)
            .setSpeedScroll(2000)
            .setAnimCloseTechnique(JumperAnimType.ZOOMOUT)
            .build()
```
and if you are using AppBar with these animation please add this attribute in your AppBarLayout
`android:stateListAnimator="@null"`

## Other Sample
```java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_material_button);

        loadFood();

        RecyclerView recyclerView = findViewById(R.id.recyclerview_main);
        MaterialButton materialButton = findViewById(R.id.to_top);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        try {
            new JumperObject.Builder(this)
                    .setJumperRecyclerView(recyclerView)
                    .setCustomMaterialButton(materialButton)
                    .hideWhenScrollUp(true)
                    .setAnimStartTechnique(JumperAnimType.PERSONAL_USE_TRANLATION_Y_UP)
                    .setAnimCloseTechnique(JumperAnimType.PERSONAL_USE_TRANLATION_Y_BOTTOM)
                    .setSpeedScroll(2000)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        FoodAdapter adapter = new FoodAdapter(listOfFoods);
        recyclerView.setAdapter(adapter);
    }
 ```
 This will display like below

<a target="_blank" rel="noopener noreferrer" href="/demo/jumper_with_materialcustom.gif"><img src="/demo/jumper_with_materialcustom.gif" width="350" style="max-width:100%;"></a>


  
## Lisense
[Apache 2.0](http://www.opensource.org/licenses/apache2.0.php)
