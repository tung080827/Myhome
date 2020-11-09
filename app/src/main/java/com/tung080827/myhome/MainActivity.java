package com.tung080827.myhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {
    MqttAndroidClient client;
    ToggleButton togglebutton1;
    ToggleButton togglebutton2;
    ToggleButton togglebutton3;
    ToggleButton togglebutton4;
//    ToggleButton togglebutton5;
//    ToggleButton togglebutton6;
//    ToggleButton togglebutton7;
//    ToggleButton togglebutton8;
//    ToggleButton togglebutton9;
//    ToggleButton togglebutton10;
    String toggleButtonSub;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        togglebutton1 = (ToggleButton) findViewById(R.id.toggle1);
        togglebutton2 = (ToggleButton) findViewById(R.id.toggle2);
        togglebutton3 = (ToggleButton) findViewById(R.id.toggle3);
//        togglebutton4 = (ToggleButton) findViewById(R.id.toggle4);
//        togglebutton5 = (ToggleButton) findViewById(R.id.toggle5);
//        togglebutton6 = (ToggleButton) findViewById(R.id.toggle6);
//        togglebutton7 = (ToggleButton) findViewById(R.id.toggleButton1);
//        togglebutton8 = (ToggleButton) findViewById(R.id.toggleButton1);
//        togglebutton9 = (ToggleButton) findViewById(R.id.toggleButton1);
//        togglebutton10 = (ToggleButton) findViewById(R.id.toggleButton1);
if(checkConnect())
{
    togglebutton1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(togglebutton1.isChecked()){
                try{
                    MqttMessage message = new MqttMessage(("11").getBytes());
                    client.publish("RL", message);
                } catch (MqttException e){
                    e.printStackTrace();
                }
            } else{
                try{
                    MqttMessage message = new MqttMessage(("10").getBytes());
                    client.publish("RL", message);
                } catch (MqttException e){
                    e.printStackTrace();
                }
            }
        }
    });

    togglebutton2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(togglebutton2.isChecked()){
                try{
                    MqttMessage message = new MqttMessage(("21").getBytes());
                    client.publish("RL", message);
                } catch (MqttException e){
                    e.printStackTrace();
                }
            } else{
                try{
                    MqttMessage message = new MqttMessage(("20").getBytes());
                    client.publish("RL", message);
                } catch (MqttException e){
                    e.printStackTrace();
                }
            }
        }
    });
    togglebutton3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(togglebutton3.isChecked()){
                try{
                    MqttMessage message = new MqttMessage(("31").getBytes());
                    client.publish("RL", message);
                } catch (MqttException e){
                    e.printStackTrace();
                }
            } else{
                try{
                    MqttMessage message = new MqttMessage(("30").getBytes());
                    client.publish("RL", message);
                } catch (MqttException e){
                    e.printStackTrace();
                }
            }
        }
    });
//        togglebutton4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(togglebutton4.isChecked()){
//                    try{
//                        MqttMessage message = new MqttMessage(("41").getBytes());
//                        client.publish("RL", message);
//                    } catch (MqttException e){
//                        e.printStackTrace();
//                    }
//                } else{
//                    try{
//                        MqttMessage message = new MqttMessage(("40").getBytes());
//                        client.publish("RL", message);
//                    } catch (MqttException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        togglebutton5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(togglebutton5.isChecked()){
//                    try{
//                        MqttMessage message = new MqttMessage(("51").getBytes());
//                        client.publish("RL", message);
//                    } catch (MqttException e){
//                        e.printStackTrace();
//                    }
//                } else{
//                    try{
//                        MqttMessage message = new MqttMessage(("50").getBytes());
//                        client.publish("RL", message);
//                    } catch (MqttException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        togglebutton6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(togglebutton6.isChecked()){
//                    try{
//                        MqttMessage message = new MqttMessage(("61").getBytes());
//                        client.publish("RL", message);
//                    } catch (MqttException e){
//                        e.printStackTrace();
//                    }
//                } else{
//                    try{
//                        MqttMessage message = new MqttMessage(("60").getBytes());
//                        client.publish("RL", message);
//                    } catch (MqttException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });


    MqttConnectOptions options = new MqttConnectOptions();
    options.setUserName("ubspgagk");
    options.setPassword("catWuPBvpbsd".toCharArray());
    String clientId = MqttClient.generateClientId();
    client =
            new MqttAndroidClient(this.getApplicationContext(), "tcp://m14.cloudmqtt.com:10590",
                    clientId);

    try {
        IMqttToken token = client.connect(options);
        token.setActionCallback(new IMqttActionListener() {
            @Override
            public void onSuccess(IMqttToken asyncActionToken) {
                // We are connected
                Log.d("mqtt", "onSuccess");
                Toast.makeText(MainActivity.this,"Connected",Toast.LENGTH_LONG).show();
                suscripcionTopics();
//                    pub("21");
            }

            @Override
            public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                // Something went wrong e.g. connection timeout or firewall problems
                Log.d("mqtt", "onFailure");
                Toast.makeText(MainActivity.this,"Can't Connected",Toast.LENGTH_LONG).show();

            }
        });
    } catch (MqttException e) {
        e.printStackTrace();
    }
    ///////////////////////////////////
    client.setCallback(new MqttCallback() {
        @Override
        public void connectionLost(Throwable cause) {

        }

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {

            if(topic.matches("RL")) {
                toggleButtonSub = new String(message.getPayload());
                switch (toggleButtonSub) {
                    case "11":
                        togglebutton1.setChecked(true);
                        break;
                    case "10":
                        togglebutton1.setChecked(false);
                        break;
                    case "21":
                        togglebutton2.setChecked(true);
                        break;
                    case "20":
                        togglebutton2.setChecked(false);
                        break;
                    case "31":
                        togglebutton3.setChecked(true);
                        break;
                    case "30":
                        togglebutton3.setChecked(false);
                        break;
//                        case "41":
//                            togglebutton4.setChecked(true);
//                            break;
//                        case "40":
//                            togglebutton4.setChecked(false);
//                            break;
//                        case "51":
//                            togglebutton5.setChecked(true);
//                            break;
//                        case "50":
//                            togglebutton5.setChecked(false);
//                            break;
//                        case "61":
//                            togglebutton6.setChecked(true);
//                            break;
//                        case "60":
//                            togglebutton6.setChecked(false);
//                            break;
                    default:
                        break;

                }
            }

//                if(topic.matches("IoT/Led2")){
//                    estadoSwitch2 = new String(message.getPayload());
//
//                    if(estadoSwitch2.matches("ON")){
//                        SwitchLed2.setChecked(true);
//                    }else{
//                        SwitchLed2.setChecked(false);
//                    }
//                }
//
//                //Card 2 y 3
//
//                if(topic.matches("IoT/Pot1")){
//                    gaugeA.setValue(Integer.parseInt(new String(message.getPayload())));
//                    textGagueA.setText(new String(message.getPayload()));
//                }
//
//                if(topic.matches("IoT/Pot2")){
//                    gaugeB.setValue(Integer.parseInt(new String(message.getPayload())));
//                    textGagueB.setText(new String(message.getPayload()));
//                }
//
//
//                // Card 5
//
//                if(topic.matches("IoT/Temp")){
//                    textTemp.setText(new String(message.getPayload()));
//                }
//
//
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {

        }
    });
}else {
    Toast.makeText(MainActivity.this,"No Internet Available, Please Check your Internet",Toast.LENGTH_LONG).show();
}
}


    private void suscripcionTopics(){

        try{
            client.subscribe("RL",2);

        }catch (MqttException e){
            e.printStackTrace();
        }

    }
    private boolean checkConnect()
    {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;
        return connected;
    }

//    void pub(String content){
//        String topic = "RL";
//        String payload = content;
//        byte[] encodedPayload = new byte[0];
//        try {
//            encodedPayload = payload.getBytes("UTF-8");
//            MqttMessage message = new MqttMessage(encodedPayload);
//            client.publish(topic, message);
//        } catch (UnsupportedEncodingException | MqttException e) {
//            e.printStackTrace();
//        }
//    }
}
