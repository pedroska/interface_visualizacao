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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
 
@ManagedBean
public class BarChart implements Serializable {
 
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() throws ParseException {
        BarChartModel model = new BarChartModel();
 
        ChartSeries rebanho = new ChartSeries();
        rebanho.setLabel("Herd1964");
        
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
                        rebanho.set(data, Integer.parseInt(nodes.item(i).getChildNodes().item(2).getTextContent()));
                }
            }catch (ParserConfigurationException | SAXException | IOException | DOMException | NumberFormatException e) {
            }
            }catch (MalformedURLException e) {
            }catch (IOException e) {
            }
 
        model.addSeries(rebanho);
        //model.addSeries(vacas);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
        try {
            createHorizontalBarModel();
        } catch (ParseException ex) {
            Logger.getLogger(BarChart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private void createBarModel() {
        try {
            barModel = initBarModel();
        } catch (ParseException ex) {
            Logger.getLogger(BarChart.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        barModel.setTitle("Total Dairy Controls");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Date");
        xAxis.setTickAngle(45); 
        
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Total Dairy Controls");
        yAxis.setMin(0);
        yAxis.setMax(50);
        yAxis.setTickInterval("10");
        yAxis.setTickFormat("%d");
    }
     
    private void createHorizontalBarModel() throws ParseException {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries rebanho = new ChartSeries();
        rebanho.setLabel("Herd1964");
 
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
                        rebanho.set(data, Integer.parseInt(nodes.item(i).getChildNodes().item(2).getTextContent()));
                }
            }catch (ParserConfigurationException | SAXException | IOException | DOMException | NumberFormatException e) {
            }
            }catch (MalformedURLException e) {
            }catch (IOException e) {
            }
        //ChartSeries vacas = new ChartSeries();
        //vacas.setLabel("Vacas");
        //vacas.set("2004", 52);
        //vacas.set("2005", 60);
        //vacas.set("2006", 82);
        //vacas.set("2007", 35);
        //vacas.set("2008", 120);
 
        horizontalBarModel.addSeries(rebanho);
        //horizontalBarModel.addSeries(vacas);
         
        horizontalBarModel.setTitle("Total Dairy Controls (Horizontal)");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Total Dairy Controls2222");
        xAxis.setMin(0);
        xAxis.setMax(50);
        xAxis.setTickFormat("%d");
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Date");
        yAxis.setTickAngle(45);
    }
 
}
