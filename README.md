# Android RateIt library

Android RateIt library prompts the users to rate and comment your App.

# Contribute

Fork this project and send pull requests, i will merge as soon as possible.

# To add the library to your Project

* New -> Android Project -> Create project from existing source, choose org_donations 
* Add sa_rateit (Properties of your project -> Android -> Library -> add org_donations as android library)

* Add a new Activity to your AndroidManifest

```xml
<activity
    android:name="sa.rateit.RateItActivity"
    android:excludeFromRecents="true"
    android:label="RateIt"
    android:launchMode="singleTask"/>
```

* Copy the file ``rateit_config.xml`` to ``res/values/`` of your project
* Modify this file to set the rate
* Add RateIt in your main Activity, when your App start...

```java
protected void onCreate(Bundle savedInstanceState) {
...
	RateIt rateit = new RateIt(this);
	rateit.prompt();
...
}
```