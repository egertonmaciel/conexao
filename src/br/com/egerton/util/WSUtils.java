//package br.com.egerton.util;
//
//import br.com.sescsc.relatorioWifi.modelo.Credenciais;
//import br.com.sescsc.relatorioWifi.modelo.RetornoJsonLogin;
//import br.com.sescsc.relatorioWifi.modelo.Unidade;
//import br.com.sescsc.relatorioWifi.util.SortByName;
//import br.com.sescsc.relatorioWifi.util.TestesUtils;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//import java.nio.charset.Charset;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.X509Certificate;
//import java.util.ArrayList;
//import java.util.Collections;
//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSession;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//public class WSUtils {
//
//    private static Gson gson = new Gson();
//
//    public static RetornoJsonLogin autenticarWS(Credenciais credenciais) throws KeyManagementException, NoSuchAlgorithmException, MalformedURLException, ProtocolException, IOException {
//
//        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
//            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//
//            public void checkClientTrusted(X509Certificate[] certs, String authType) {
//            }
//
//            public void checkServerTrusted(X509Certificate[] certs, String authType) {
//            }
//        }
//        };
//
//        SSLContext sc = SSLContext.getInstance("SSL");
//        sc.init(null, trustAllCerts, new java.security.SecureRandom());
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//
//        HostnameVerifier allHostsValid = new HostnameVerifier() {
//            public boolean verify(String hostname, SSLSession session) {
//                return true;
//            }
//        };
//
//        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
//
//        RetornoJsonLogin retornoJsonLogin = new RetornoJsonLogin();
//        String jsonCredenciais = gson.toJson(credenciais);
//
//        URL url = new URL("https://130.10.0.44:8090/WSAuthCan/servidor/autenticar");
//        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
//        con.setRequestProperty("Authorization", "Basic cGxhdGFmb3JtYW1vYmlsZToyYzgyNmMxMC0wMWJiLTQwNDMtYjI1Yi01OTE4MmM1NjVmNzk=");
//        con.setRequestProperty("Content-Type", "application/json");
//        con.setDoOutput(true);
//        con.setDoInput(true);
//        con.setRequestMethod("POST");
//
//        try (OutputStream outputStream = con.getOutputStream()) {
//            outputStream.write(jsonCredenciais.getBytes("UTF-8"));
//        }
//
//        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((con.getInputStream()), Charset.forName("UTF-8")));
//        String output = "";
//        String retorno = "";
//        while ((output = responseBuffer.readLine()) != null) {
//            retorno += output;
//        }
//        try {
//            retornoJsonLogin = gson.fromJson(retorno, RetornoJsonLogin.class);
//        } catch (Exception e) {
//            System.out.println("FALHA PARA CONVERTER: " + e);
//        }
//
//        con.disconnect();
//        responseBuffer.close();
//
//        return retornoJsonLogin;
//    }
//
//    public static ArrayList<Unidade> listarUnidadesWS(String usuario) throws KeyManagementException, NoSuchAlgorithmException, MalformedURLException, ProtocolException, IOException {
//
//        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
//            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//
//            public void checkClientTrusted(X509Certificate[] certs, String authType) {
//            }
//
//            public void checkServerTrusted(X509Certificate[] certs, String authType) {
//            }
//        }
//        };
//
//        SSLContext sc = SSLContext.getInstance("SSL");
//        sc.init(null, trustAllCerts, new java.security.SecureRandom());
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//
//        HostnameVerifier allHostsValid = new HostnameVerifier() {
//            public boolean verify(String hostname, SSLSession session) {
//                return true;
//            }
//        };
//
//        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
//
//        ArrayList<Unidade> unidades = new ArrayList<>();
//
//        URL url = new URL("https://130.10.0.44:8090/WSAuthCan/servidor/unidades?usuario=" + usuario);
//
//        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
//        con.setRequestProperty("Authorization", "Basic cGxhdGFmb3JtYW1vYmlsZToyYzgyNmMxMC0wMWJiLTQwNDMtYjI1Yi01OTE4MmM1NjVmNzk=");
//        con.setDoOutput(true);
//        con.setRequestMethod("GET");
//
//        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((con.getInputStream()), Charset.forName("UTF-8")));
//        String output = "";
//        String retorno = "";
//        while ((output = responseBuffer.readLine()) != null) {
//            retorno += output;
//        }
//
//        try {
//            unidades = gson.fromJson(retorno, new TypeToken<ArrayList<Unidade>>() {
//            }.getType());
//        } catch (Exception e) {
//            System.out.println("FALHA PARA CONVERTER: " + e);
//        }
//
//        // SOMENTE PARA TESTES
//        unidades = TestesUtils.unidadesTeste();
//
//        Collections.sort(unidades, new SortByName());
//
//        con.disconnect();
//        responseBuffer.close();
//
//        return unidades;
//    }
//
//}
