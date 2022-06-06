# report by Nibar Ahmed
##design
this is a design idea for the app that was developed before developing code for the app.
the first screen user is presented with when opening the app lets the user choose to either see information about cars or read about the app. If the user desides to read about the app a neww screen appears with an app description. If the user instead decies to read about cars they are taken to a screen and presented with a list of cars and some info about each car in the list. 
##web service JSON data
When fetching data for the app a web service was used to fetch the data. The web service provides an admin interface for adding JSON data that was used in the project. Below is an example of a JSON object that the app used. 
```
[{"ID":"1_volvo","name":"xc60","type":"a21nibah","company":"volvo","location":"","category":"suv","size":0,"cost":0,"auxdata":""}]
```
the name atribute stores the model name of each car. Company stores the name of the company that manufactures the car. Category stores information about what type of vehicle the car is, examples of types include sedans and sports utility vehicles.
One of the goals were to make it easy to work with the atributes that the admin interface provides and that's why the meaning of the data atributes match the atributes for the admin interface. 
##implementation examples
###example1
a button was added to the main activity that allows the user to be directed to another activity that shows information about the app. This was done using intents which allows developers to launch other activitys and include data. A listener was used for the button. A listener listens for events like when a button is klicked.
following link is for the commit on git hub that describes the change made :
https://github.com/a21nibah/androidProject/commit/a951c46a0f1dcddb86e330e9750a0de4aa96240e
below is the code that shows how the about activity of the app is launched:
```
        aboutBtn=findViewById(R.id.launch_about_activity_btn);
Intent aboutIntent=new Intent(this, AboutActivity.class);
           aboutBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               startActivity(aboutIntent);
            }
        });     
```
###example 2
following is the link for the commit that lists the change made for this code:
https://github.com/a21nibah/androidProject/commit/17cbf27c5e925eb6c685fdb8de035df040e7912a
in order for the app to be able to connect to the internet permissions must first be specified in the manifest file of the app. Following is the code for requesting permission to connect to the internet:
```
<uses-permission android:name="android.permission.INTERNET"/>
```
below is of the code for fetching JSON data:
```
public class InformationActivity extends AppCompatActivity implements JsonTask.JsonTaskListener
{
    private final String jsonUrl = "https://mobprog.webug.se/json-api?login=a21nibah";
    private ArrayList<Car> cars;
private Gson gson;
private Type type;
private RecyclerView recView;
private CarAdapter carAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        recView=findViewById(R.id.rec_view);
recView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
cars=new ArrayList<Car>();
carAdapter=new CarAdapter(cars);
recView.setAdapter(carAdapter);
        type = new TypeToken<ArrayList<Car>>() {}.getType();
gson=new Gson();
new JsonTask(this).execute(jsonUrl);
    }
    @Override
    public void onPostExecute(String json)
    {
        //we create a new temp list and fetch the json data and put it in there before we update the mountain list.
        ArrayList<Car> temp=new ArrayList<Car>();
        temp=gson.fromJson(json, type);
//we make sure that the array list is cleared before we add to it.
        cars.clear();
        cars.addAll(temp);
        carAdapter.notifyDataSetChanged();

    }
}
```
first the views and adapters along with the gson library are initialised. The gson library is used to fetch the JSON data. The code for fetching the data was provided as part of the project assignment. The gson library also needs to know what type of data is being fetched which was provided on line 18 of the code above.
An array list was also provided to the car adapter which manages the recycler view and ensures that content is correctly presented on the screen. The car list is initially empty.
the onPostExecute function creates a new temp list and stores the JSON data. This is done in order to make sure that data is correctly fetched before we update the main list. after the data is fetched and put in the temp list the main list is cleared and then data from the temp list is copyed to the main list. The adapter then gets notified that there are changes and refreshes the recycler view. A more elegant aproach would be to have a setter that instead sets the array list in the adapter. This way performence can be increased since data doesn't have to be copyed from one list to another, as a result the amount of code would decrease abit.
##reflection
I think over all the the course was well structured and the concepts of weekly assignments really made it intresteing and easy to studdy this course. One issue that I have is with the project assignment. There is a requirement that the project needs to be  worked on during multiple days. The amount of days is not specified though and to make matters even worse the project isn't hard enough to warrent this requirement. I Understand why this requirement is present but I believe that this project doesn't allow us to fulfill this requirement since you can be done in a few hours no matter if you want g or vg.
I think that you either need to remove this requirement and instead have it apply on one of the assignments, I believe the JSON assignment could work. Another alternative is to try to make the project bigger so that you are forced to work longer to finish it. I believe that as things stand now it's unrealistic to demand that you split up your work in multiple days just to satisfy this requirement when you easely can finish this project in a few hours. I mean if you think about it when you work for a real company why would they give you an easy tasks and then require you to work for multiple days to finish it if you can do it well in a few hours? that doesn't make sence at all. 

I think the best solution would be to make the project bigger and preferably have it so that you can't reuse code from older assignment in order to make sure that all the project code is your own and that you've spent time writing it and testing.