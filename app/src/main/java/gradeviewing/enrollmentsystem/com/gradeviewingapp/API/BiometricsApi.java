package gradeviewing.enrollmentsystem.com.gradeviewingapp.API;

import android.content.Context;

import org.json.JSONObject;

import java.util.HashMap;

import gradeviewing.enrollmentsystem.com.gradeviewingapp.GlobalVariables;

/**
 * Created by john_bandong on 4 Nov 2016.
 */
public class BiometricsApi {

    Context mContext;
    public BiometricsApi(Context context) {
        this.mContext = context;
    }

    public JSONObject Token(HashMap<String, String> params) {
        String JSONBody = (new JSONObject(params)).toString();
        String result = (new RestAPI()).httpPostResponse1("http://222.127.16.135/BiometricsAPI/api/Login", JSONBody);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }

    public JSONObject MGToken(HashMap<String, String> params) {
        String JSONBody = (new JSONObject(params)).toString();
        String result = (new RestAPI()).httpPostResponse1("http://222.127.16.135/MemberGatewayAPI/api/Login", JSONBody);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }


    public JSONObject ValidateFace(String Token, HashMap<String, String> params) {
        String JSONBody = (new JSONObject(params)).toString();
        String result = (new RestAPI()).httpPostResponse("http://222.127.16.135/BiometricsAPI/Face/Verify", JSONBody, Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }
    public JSONObject EnrollFace(String Token, HashMap<String, String> params) {
        String JSONBody = (new JSONObject(params)).toString();
        String result = (new RestAPI()).httpPostResponse("http://222.127.16.135/BiometricsAPI/Face/Enroll", JSONBody, Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }

    public JSONObject EnrollFaceToMG(String id,String Base64String,String Token) {
        String JSONBody = Base64String;
        String result = (new RestAPI()).httpPostResponse("http://222.127.16.135/MemberGatewayAPI/MG/MemberProfile?empId="+id, "\""+JSONBody +"\"", Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }
    public JSONObject TagEnroll(String id,String SID,String Token) {
        String JSONBody = SID;
        String result = (new RestAPI()).httpPostResponse("http://222.127.16.135/MemberGatewayAPI/MG/TagEnrolledToBMS?empId="+id, "\""+JSONBody +"\"", Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }


    public JSONObject GetProfile(String id,String Token) {
        String result = (new RestAPI()).httpGetResponse("http://222.127.16.135/MemberGatewayAPI/MG/MemberProfile?empId="+id, Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }
    public JSONObject IsAutoVerify(String id,String Token) {
        String result = (new RestAPI()).httpGetResponse("http://222.127.16.135/MemberGatewayAPI/MG/IsMemberAutoVerify?empId="+id, Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }
    public JSONObject DetectFace(String Token, HashMap<String, String> params) {
        String JSONBody = (new JSONObject(params)).toString();
        String result = (new RestAPI()).httpPostResponse("http://222.127.16.135/BiometricsAPI/Face/DetectFace", JSONBody, Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }
    public JSONObject DetectNose(String Token, HashMap<String, String> params) {
        String JSONBody = (new JSONObject(params)).toString();
        String result = (new RestAPI()).httpPostResponse("http://222.127.16.135/BiometricsAPI/Face/DetectNose", JSONBody, Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }
    public JSONObject DetectEyes(String Token, HashMap<String, String> params) {
        String JSONBody = (new JSONObject(params)).toString();
        String result = (new RestAPI()).httpPostResponse("http://222.127.16.135/BiometricsAPI/Face/DetectEyes", JSONBody, Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }

    public JSONObject LoginUser(String id,String password,String Token) {
        String result = (new RestAPI()).httpGetResponse("http://"+ GlobalVariables.apiAddress+":8081/ENROLLMENTSYSTEM/SERVICES/student.php?action=login&studentid="+id+"&password="+password, Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }
    public JSONObject StudentInfo(String id,String Token) {
        String result = (new RestAPI()).httpGetResponse("http://"+ GlobalVariables.apiAddress+":8081/ENROLLMENTSYSTEM/SERVICES/student.php?action=studentinfo&studentid="+id, Token);
        String[] split = result.split("\\|");
        HashMap<String, String> hash = new HashMap<>();
        hash.put("ResponseCode", split[0]);
        hash.put("Data", split[1]);
        return new JSONObject(hash);
    }







}
