# ZGallery
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ZGallery-brightgreen.svg?style=plastic)]()
[![](https://jitpack.io/v/mzelzoghbi/ZGallery.svg)](https://jitpack.io/#mzelzoghbi/ZGallery)

Android 3rd party library to make implementing galleries more easier

I found myself writing the same Gallery Feature in many apps with the same code, so i made this library to make developers life more easier and prevent wasting their time.

You can checkout the sample app, or view the app directly on GooglePlayStore

<a href='https://play.google.com/store/apps/details?id=com.mzelzoghbi.zgallery'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width="300px"/></a>


It includes two activities : 
* For displaying a list of images in `GridLayout` using `RecyclerView`.
* For displaying images in a `ViewPager` with a nice scroll `HorizontalList` and nice zooming gestures **Thanks for [PhotoView Library](https://github.com/chrisbanes/PhotoView)** 

## Screenshots
<a href="https://youtu.be/eJ70DDmr2FE"><img src="https://github.com/mzelzoghbi/ZGallery/blob/master/ZGallery_lib_sample_preview.gif" alt="" width="200px"></a>
<a href="https://github.com/mzelzoghbi/ZGallery/blob/master/screenshot_grid.png"><img src="https://github.com/mzelzoghbi/ZGallery/blob/master/screenshot_grid.png" alt="" width="200px"></a>
<a href="https://github.com/mzelzoghbi/ZGallery/blob/master/screenshot_gallery.png"><img src="https://github.com/mzelzoghbi/ZGallery/blob/master/screenshot_gallery.png" alt="" width="200px"></a>



## How it works
### Grid List Builder

Simply with a very nice builder you will find it done.
```java
ZGrid.with(this, /*your string arraylist of image urls*/)
                .setToolbarColorResId(R.color.colorPrimary) // toolbar color
                .setTitle("Zak Gallery") // toolbar title
                .setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                .setSpanCount(3) // colums count
                .setGridImgPlaceHolder(R.color.colorPrimary) // color placeholder for the grid image until it loads
                .show();
```


### Gallery Builder

```java
ZGallery.with(this, /*your string arraylist of image urls*/)
                .setToolbarTitleColor(ZColor.WHITE) // toolbar title color
                .setGalleryBackgroundColor(ZColor.WHITE) // activity background color
                .setToolbarColorResId(R.color.colorPrimary) // toolbar color
                .setTitle("Zak Gallery") // toolbar title
                .show();
```
                
## Installation

Add this to your **root** build.gradle file (not your module build.gradle file) :
```java
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```

Add this to your module `build.gradle` file:
```java
dependencies {
  ...
    compile 'com.github.mzelzoghbi:zgallery:0.3'
}
```

# License

> Copyright 2016 mzelzoghbi

> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

> Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
