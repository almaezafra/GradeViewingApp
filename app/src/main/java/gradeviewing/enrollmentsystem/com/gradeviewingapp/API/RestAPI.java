package gradeviewing.enrollmentsystem.com.gradeviewingapp.API;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by john_dongalen on 4/15/2016.
 */
public class RestAPI {
    private String HttpResponse = "";
    private String HttpsResponse = "";

    public RestAPI() {
    }

    protected String httpGetResponse(String SERVICE_URL, String Token) {
        this.httpGetMethod(SERVICE_URL, Token);
        return this.HttpResponse;
    }
    protected String httpPostResponse1(String SERVICE_URL, String JsonString) {
        this.httpPostMethod(SERVICE_URL, JsonString);
        return this.HttpResponse;
    }
    protected String httpPostResponse(String SERVICE_URL, String JsonString, String Token) {
        this.httpPostMethod(SERVICE_URL, JsonString, Token);
        return this.HttpResponse;
    }

    protected String httpsGetResponse(String SERVICE_URL, String Token) {
        this.httpsGetMethod(SERVICE_URL, Token);
        return this.HttpsResponse;
    }

    protected String httpsPostResponse(String SERVICE_URL, String JsonString, String Token) {
        this.httpsPostMethod(SERVICE_URL, JsonString, Token);
        return this.HttpsResponse;
    }

    private void httpsGetMethod(String SERVICE_URL, String Token) {
        int ResponseCode = 0;
        String JsonString ="";

        try {
            URL e = new URL(SERVICE_URL);
            HttpURLConnection conn = (HttpURLConnection) e.openConnection();
            conn.setReadTimeout(120000);
            conn.setConnectTimeout(120000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Authorization", "bearer " + Token);
            conn.connect();
            ResponseCode = conn.getResponseCode();
            BufferedReader _buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer response = new StringBuffer();

            String _InputLine;
            while ((_InputLine = _buff.readLine()) != null) {
                response.append(_InputLine);
            }

            this.HttpResponse = ResponseCode + "|" + response.toString();
        } catch (Exception var11) {
            this.HttpResponse = ResponseCode + "|" + var11.getMessage();
        }
    }

    protected void httpsPostMethod(String SERVICE_URL, String JsonString, String Token) {
        int ResponseCode = 0;

        try {
            URL e = new URL(SERVICE_URL);
            HttpsURLConnection conn = (HttpsURLConnection) e.openConnection();
            conn.setReadTimeout(120000);
            conn.setConnectTimeout(120000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.connect();
            OutputStream out = conn.getOutputStream();
            out.write(JsonString.toString().getBytes());
            out.close();
            ResponseCode = conn.getResponseCode();
            BufferedReader _buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer response = new StringBuffer();

            String _InputLine;
            while ((_InputLine = _buff.readLine()) != null) {
                response.append(_InputLine);
            }

            this.HttpResponse = ResponseCode + "|" + response.toString();
        } catch (Exception var11) {
            this.HttpsResponse = ResponseCode + "|" + var11.getMessage();
        }

    }

    private void httpGetMethod(String SERVICE_URL, String Token) {
        int ResponseCode = 0;
        String JsonString ="";

        try {
            URL e = new URL(SERVICE_URL);
            HttpURLConnection conn = (HttpURLConnection) e.openConnection();
            conn.setReadTimeout(120000);
            conn.setConnectTimeout(120000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Authorization", "bearer " + Token);
            conn.connect();
            ResponseCode = conn.getResponseCode();
            BufferedReader _buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer response = new StringBuffer();

            String _InputLine;
            while ((_InputLine = _buff.readLine()) != null) {
                response.append(_InputLine);
            }

            this.HttpResponse = ResponseCode + "|" + response.toString();
        } catch (Exception var11) {
            this.HttpResponse = ResponseCode + "|" + var11.getMessage();
        }
    }
    private void httpPostMethod(String SERVICE_URL, String JsonString) {
        int ResponseCode = 0;

        String responseMessage;
        try {
            URL e = new URL(SERVICE_URL);
            HttpURLConnection conn = (HttpURLConnection) e.openConnection();
            conn.setReadTimeout(120000);
            conn.setConnectTimeout(120000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.connect();
            OutputStream out = conn.getOutputStream();
            out.write(JsonString.toString().getBytes());
            out.close();
            ResponseCode = conn.getResponseCode();
            if(ResponseCode == 200) {
                BufferedReader _buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuffer response = new StringBuffer();

                String _InputLine;
                while ((_InputLine = _buff.readLine()) != null) {
                    response.append(_InputLine);
                }
                this.HttpResponse = ResponseCode + "|" + response.toString();
            }
            else
            {
                String x = conn.getClass().toString();
                InputStreamReader ip = new InputStreamReader(conn.getErrorStream());
                BufferedReader reader = new BufferedReader(ip);
                StringBuffer response = new StringBuffer();

                String _InputLine;
                while ((_InputLine = reader.readLine()) != null) {
                    response.append(_InputLine);
                }
                this.HttpResponse =  ResponseCode + "|" + response.toString();
            }
        } catch (Exception var11) {
            this.HttpResponse = ResponseCode + "|" + var11.getMessage();
        }

    }

    private void httpPostMethod(String SERVICE_URL, String JsonString, String Token) {
        int ResponseCode = 0;

        String responseMessage;
        try {
            URL e = new URL(SERVICE_URL);
            HttpURLConnection conn = (HttpURLConnection) e.openConnection();
            conn.setReadTimeout(120000);
            conn.setConnectTimeout(120000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "bearer " + Token);
            conn.connect();
            OutputStream out = conn.getOutputStream();
            out.write(JsonString.toString().getBytes());
            out.close();
            ResponseCode = conn.getResponseCode();
            if(ResponseCode == 200) {
                BufferedReader _buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuffer response = new StringBuffer();

                String _InputLine;
                while ((_InputLine = _buff.readLine()) != null) {
                    response.append(_InputLine);
                }
                this.HttpResponse = ResponseCode + "|" + response.toString();
            }
            else
            {
                String x = conn.getClass().toString();
                InputStreamReader ip = new InputStreamReader(conn.getErrorStream());
                BufferedReader reader = new BufferedReader(ip);
                StringBuffer response = new StringBuffer();

                String _InputLine;
                while ((_InputLine = reader.readLine()) != null) {
                    response.append(_InputLine);
                }
                this.HttpResponse =  ResponseCode + "|" + response.toString();
            }
        } catch (Exception var11) {
            this.HttpResponse = ResponseCode + "|" + var11.getMessage();
        }

    }
}
