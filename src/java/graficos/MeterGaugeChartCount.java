package graficos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/**
 *
 * @author Pedro Ivo
 */
    
@ManagedBean
public class MeterGaugeChartCount implements Serializable {
 
    private MeterGaugeChartModel meterGaugeModel1;
    private MeterGaugeChartModel meterGaugeModel2;
 
    @PostConstruct
    public void init() {
        createMeterGaugeModels();
    }
 
    public MeterGaugeChartModel getMeterGaugeModel1() {
        return meterGaugeModel1;
    }
     
    public MeterGaugeChartModel getMeterGaugeModel2() {
        return meterGaugeModel2;
    }
 
    private MeterGaugeChartModel initMeterGaugeModel() {
        
        Integer value = 0;
        List<Number> intervals = new ArrayList<Number>(){{
            add(100);
            add(200);
            add(300);
        }};
        
        //Incluindo os dados obtidos no gráfico
        try {
            
            URL url = new URL("http://localhost:8080/visualizacao_semantica_estrutural/resources/producao_rebanho_data");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/xml");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }

            conn.disconnect();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder;  
            try{
            builder = factory.newDocumentBuilder();  
                Document document = builder.parse( new InputSource( new StringReader( output ) ) );
                
                NodeList nodes = document.getElementsByTagName("producaoRebanhoData");
                for(int i = 0; i < nodes.getLength(); i++){        
                    value += Integer.parseInt(nodes.item(i).getChildNodes().item(2).getTextContent());
                }
                
                
            }catch (ParserConfigurationException | SAXException | IOException | DOMException | NumberFormatException e) {
            }
            }catch (MalformedURLException e) {
            }catch (IOException e) {
            }
        /*List<Number> intervals = new ArrayList<Number>(){{
            add(20);
            add(50);
            add(120);
            add(220);
        }};*/
        return new MeterGaugeChartModel (value,intervals);
    }
 
    private void createMeterGaugeModels() {
        meterGaugeModel1 = initMeterGaugeModel();
        meterGaugeModel1.setTitle("Rebanho1964");
        meterGaugeModel1.setGaugeLabel("Controles");
        meterGaugeModel1.setGaugeLabelPosition("Bottom");
        meterGaugeModel1.setSeriesColors("ff0000,ff8c00,00ff7f");
         
        //meterGaugeModel2 = initMeterGaugeModel();
        //meterGaugeModel2.setTitle("Custom Options");
        //meterGaugeModel2.setSeriesColors("66cc66,93b75f,E7E658,cc6666");
        //meterGaugeModel2.setGaugeLabel("km/h");
        //meterGaugeModel2.setGaugeLabelPosition("bottom");
        //meterGaugeModel2.setShowTickLabels(false);
        //meterGaugeModel2.setLabelHeightAdjust(110);
        //meterGaugeModel2.setIntervalOuterRadius(100);
    }
 
}