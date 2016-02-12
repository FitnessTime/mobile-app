package com.fitnesstime.fitnesstime.Servicios;

import android.util.Log;

import com.fitnesstime.fitnesstime.Modelo.SecurityToken;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by julian on 08/02/16.
 */
public class RegistroServicio {

    public String registrar(String email, String nombre, String password, String fecha, int peso)
    {
        String mensaje = "Error en el servidor, intente nuevamente.";
        try {
            URL url = new URL("http://api-fitnesstime.herokuapp.com/registrar?email="+email+"&pass="+password+"&nombre="+nombre+"&fecha="+fecha+"&peso=" + String.valueOf(peso));
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            int code = urlConnection.getResponseCode();
            if(code == 410)
                mensaje = "Ya existe un usuario con esta cuenta.";
            if(code == 411)
                mensaje = "No se pudo registrar el usuario.";
            if(code == 200)
                mensaje = "Usuario registrado.";
        }catch(Exception e)
        {
            Log.println(1, "", e.getMessage());
        }
        return mensaje;
    }
}
