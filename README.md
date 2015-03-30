# LabEngine - Android Game Engine for Beginners

## 
<b>ATTENTION! MUST READ! <br>
This engine is at an early stage of development. The following code may seem to be foolish for more experienced developers, but this is just the beginning... <br>
Send all your questions to e-mail: <granddukeyuri@gmail.com> <br>
P.S. Please forgive for my English. I'm not a native English speaker.</b>

### How to

* Create a new project in your IDE
* First of all add a package <b>com.labengine</b> to your project's <i>src/</i> folder
* Extends your Main_Activity.java with the <b>LEBaseActivity.java</b> and add unimplements methods. Like that:
```java
public class Main_Activity extends LEBaseActivity {
  @Override
	public void onLoadEngine() { }

	@Override
	public void onLoadResource() { }

	@Override
	public void onLoadScene() { }

	@Override
	public void onPauseEngine() { }
}
```
* Secondary you must to initialize engine:
  * In method <b>onLoadEngine()</b> you must create settings, initialize your scene and Surface for Drawing. In most cases, it looks like that: 
```java
...
@Override
	public void onLoadEngine() {
   LESettings.AutoScale = true;
        LESettings.setDefaultRes(480, 800);
		LESettings.Init(this, this.getWindowManager().getDefaultDisplay(), FRAMERATE);
		LESettings.setSound(true);
		LEScene scene = new LEScene(this.getWindowManager().getDefaultDisplay(), NUMBER_OF_LAYERS);
		LESurfaceView sf = new LESurfaceView(this, scene);
		this.setContentView(v);
	}
...
```
  * Then you can intialize your game's resource (textures, sounds etc.) in the method <b>onLoadResource()</b>: 
```java
...
@Override
	public void onLoadResource() {
	  LESimpleSprite sprite = new LESimpleSprite("path_to_your_image_from_assets/", this.getAssets()); 
	}
...
```
  * And finaly, you can add an object to the scene:
```java
...
@Override
	public void onLoadResource() {
	  scene.addItem(sprite);
	}
...
```
 
