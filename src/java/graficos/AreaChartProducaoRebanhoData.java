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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import thing.GerencialProducao;
 
@ManagedBean
public class AreaChartProducaoRebanhoData implements Serializable {
 
    private LineChartModel areaModel;
 
    @PostConstruct
    public void init() {
        try {
            createAreaModel();
        } catch (ParseException ex) {
            Logger.getLogger(AreaChartProducaoRebanhoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public LineChartModel getAreaModel() {
        return areaModel;
    }
     
    private void createAreaModel() throws ParseException {
        areaModel = new LineChartModel();
 
        LineChartSeries rebanho = new LineChartSeries();
        rebanho.setFill(true);
        rebanho.setLabel("Rebanho1964");
        
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
                SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
                
                for(int i = 0; i < nodes.getLength(); i++){
                        String data = formatoData.format(formatoData.parse(nodes.item(i).getChildNodes().item(0).getTextContent()));
                        rebanho.set(data, Float.parseFloat(nodes.item(i).getChildNodes().item(1).getTextContent()));
                }
            }catch (ParserConfigurationException | SAXException | IOException | DOMException | NumberFormatException e) {
            }
            }catch (MalformedURLException e) {
            }catch (IOException e) {
            }
        
        
        //LineChartSeries vacas = new LineChartSeries();
        //vacas.setFill(true);
        //vacas.setLabel("Vacas");
        //vacas.set("2004", 52);
        //vacas.set("2005", 60);
        //vacas.set("2006", 110);
        //vacas.set("2007", 90);
        //vacas.set("2008", 120);
 
        areaModel.addSeries(rebanho);
        //areaModel.addSeries(vacas);
         
        areaModel.setTitle("Produção Rebanhos");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);
         
        Axis xAxis = new CategoryAxis("Data");
        areaModel.getAxes().put(AxisType.X, xAxis);
        xAxis.setTickAngle(45);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Leite");
        yAxis.setMin(0);
        yAxis.setMax(150000);
    }
     
}