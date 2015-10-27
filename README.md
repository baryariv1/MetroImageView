# MetroImageView
MetroImageView is an Android custom ImageView that replace photos with random animations. 

To use MetroImageView you need to add "facebook/fresco" to your's app build.gradle:

https://github.com/facebook/fresco

http://frescolib.org/docs/index.html

        dependencies {

        compile 'com.facebook.fresco:fresco:0.7.0+'

        }

And add 
        
        Fresco.initialize(context); 
        
before your app calls 
        
        setContentView()

Add MetroImageView to the xml:

        <com.metroimageview.MetroImageView

        android:id="@+id/metroImageView"
        
        android:layout_width="150dp"
        
        android:layout_height="150dp"/>

Set the view basic attributes in your's class:

        MetroImageView metroImageView;

        metroImageView = (MetroImageView) findViewById(R.id.metroImageView);

        metroImageView.setAnimationSpeed(1000); //default is 2000

        metroImageView.setStartDelay(3000);	//default is 3000

Set animations to use(from 9 options):

Defaults.FADE

Defaults.SLIDE_DOWN

Defaults.SLIDE_UP

Defaults.SLIDE_LEFT

Defaults.SLIDE_RIGHT

Defaults.FLIP_UP

Defaults.FLIP_DOWN

Defaults.FLIP_LEFT

Defaults.FLIP_RIGHT

        metroImageView.setAnimationsToUse(Defaults.FADE, Defaults.SLIDE_DOWN, Defaults.SLIDE_UP);

Set list of photos Uri's:

        metroImageView.setImagesUrls(uris);
        
Add
        <uses-permission android:name="android.permission.INTERNET"/>
        
to AndroidManifest.xml

You can use any "facebook/fresco" attributes on ImageView's in metro_image_view.xml.

You can find example in MainActivity.

