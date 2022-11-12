package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// Handler value: example.HandlerWeatherData
public class HandlerWeatherData implements RequestHandler<WeatherData, WeatherData>{
	
  Gson gson = new GsonBuilder().setPrettyPrinting().create();
  
  protected WeatherData defaultData;
  public HandlerWeatherData() {
	 defaultData = new WeatherData();
	 defaultData.setTemperatureK(100);
	 
  }
  
  @Override
  public WeatherData handleRequest(WeatherData event, Context context)
  {
    LambdaLogger logger = context.getLogger();
    // process event
    logger.log("EVENT: " + gson.toJson(event));
    logger.log("EVENT TYPE: " + event.getClass().toString());
    event.setTemperatureK(defaultData.getTemperatureK());
    return event;
  }
}