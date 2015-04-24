# LabEngine - Android Game Engine for Beginners

## 
<b>ATTENTION! MUST READ! <br>
This engine is at an early stage of development. The following code may seem to be foolish for more experienced developers, but this is just the beginning... <br>
Send all your questions to e-mail: <granddukeyuri@gmail.com> <br>
P.S. Please forgive for my English. I'm not a native English speaker.</b>

### How to

* Create a new project in your IDE
* First of all, add a .jar file to <i>libs/<i> folder in your project
* Extends your Main_Activity.java with the <b>LEBaseActivity.java</b> and add unimplements methods. Like that:
```java
public class Main_Activity extends LEBaseActivity {

	public static final int FRAMERATE = 30;
	
	public LESimpleSprite sprite;
	public LEScene scene;

  	@Override
  	public void onLoadEngine() { }

	@Override
	public void onLoadResource() { }

	@Override
	public void onLoadScene() { }

	@Override
	public void onPauseEngine() { }
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
```
* Secondary you must to initialize engine:
  * In method <b>onLoadEngine()</b> you must create settings. In most cases, it looks like that: 
```java
...
	@Override
	public void onLoadEngine() {
   		LESettings.AutoScale = true;
		LESettings.setDefaultWH(480, 800);
		LESettings.Init(30);
		LESettings.setSound(true);
		LESettings.setFullScreen(true);
	}
...
```
  * Then you can intialize your game's resource (scene, textures, sounds etc.) in the method <b>onLoadResource()</b>: 
```java
...
	@Override
	public LEScene onLoadResource() {
		scene = new LEScene(0, 0, 1);
		sprite = new LESimpleSprite("sum-logo.png");
		return scene;
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
  * If you want you can add the handler touches in the method <b> onTouch() </b>
 ```java
...
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
		    	if (player.isSelected(event.getX(), event.getY())) {
				sprite.setCenterXY(event.getX(), event.getY());
			 }
		}
		return true;
	}
...
```
