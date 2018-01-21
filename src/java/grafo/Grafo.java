package grafo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.parsers.ParserConfigurationException;
import org.primefaces.context.RequestContext;
import org.xml.sax.SAXException;

@ManagedBean()
@ViewScoped
public class Grafo implements Serializable {    
//tesste
    private String teste;
    
    public Grafo() throws IOException {
        teste = null;
    }
    
    public String getTeste(){
        return this.teste;
    }
    
    public void setTeste(String teste){
        this.teste = teste;
    }
    
    public void setTeste2(){
        this.teste = "teste";
    }
   
    public void generateGraph() throws SAXException, IOException, ParserConfigurationException {
        
        System.out.println("Initializing graph for the service ");
        String script;
        
        //script = linkuriousSampleScriptGenerator();
        //url 1 = estrutura da ontologia, 2 = indivíduos da ontologia
        //script = OntologyGenerator(2);
        script = OntologyGenerator(3);
        
        if (!script.equals("")) {
            RequestContext.getCurrentInstance().execute(script);
        }
    }
  
   /**
     * Generates a Sample for a Linkurious Script
     *
     * @return
     */
    public String linkuriousSampleScriptGenerator() {
        String script = "var s,\n" +
"    g = {nodes: [],edges: []};\n" +
"\n" +
"g.nodes.push({\n" +
"      id: '33',\n" +
"      label: '33',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#000',\n" +
"      data: {\n" +
"        nomeCompleto: 'Eduardo Sany Laber',\n" +
"        nomeCompletoComEnter: 'Eduardo Laber (2)',\n" +
"        anoNaRede: '1997',\n" +
"        agregador: 'PUC-RJ;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4791540P4',\n" +
"        centralidadeLocal: '0.200806042',\n" +
"        centralidadeGlobal: '0.844057277',\n" +
"        group: '2',\n" +
"        universidade: 'PUC-RJ',\n" +
"        gruposUniversidade: 'PUC-RJ2'\n" +
"      }\n" +
"},\n" +
"{\n" +
"      id: '35',\n" +
"      label: '35',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#000',\n" +
"      data: {\n" +
"        nomeCompleto: 'Ruy Luiz Milidiu',\n" +
"        nomeCompletoComEnter: 'Ruy Milidiu (2)',\n" +
"        anoNaRede: '1997',\n" +
"        agregador: 'PUC-RJ;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4793220Y6',\n" +
"        centralidadeLocal: '0.480961289',\n" +
"        centralidadeGlobal: '0.078015311',\n" +
"        group: '2',\n" +
"        universidade: 'PUC-RJ',\n" +
"        gruposUniversidade: 'PUC-RJ2'\n" +
"      }\n" +
"},\n" +
"{\n" +
"      id: '44',\n" +
"      label: '44',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#000',\n" +
"      data: {\n" +
"        nomeCompleto: 'Arndt von Staa',\n" +
"        nomeCompletoComEnter: 'Arndt Staa (2)',\n" +
"        anoNaRede: '1976',\n" +
"        agregador: 'PUC-RJ;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4727797Z8',\n" +
"        centralidadeLocal: '0.449532905',\n" +
"        centralidadeGlobal: '0.294515532',\n" +
"        group: '2',\n" +
"        universidade: 'PUC-RJ',\n" +
"        gruposUniversidade: 'PUC-RJ2'\n" +
"      }\n" +
"},\n" +
"{\n" +
"      id: '43',\n" +
"      label: '43',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#000',\n" +
"      data: {\n" +
"        nomeCompleto: 'Eduardo Sany Laber',\n" +
"        nomeCompletoComEnter: 'Eduardo Laber (2)',\n" +
"        anoNaRede: '1997',\n" +
"        agregador: 'PUC-RJ;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4791540P4',\n" +
"        centralidadeLocal: '0.200806042',\n" +
"        centralidadeGlobal: '0.844057277',\n" +
"        group: '2',\n" +
"        universidade: 'PUC-RJ',\n" +
"        gruposUniversidade: 'PUC-RJ2'\n" +
"      }\n" +
"},\n" +
"{\n" +
"      id: '99',\n" +
"      label: '99',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#0F0',\n" +
"      data: {\n" +
"        nomeCompleto: 'Phillipe',\n" +
"        nomeCompletoComEnter: 'Phillipe',\n" +
"        anoNaRede: '1997',\n" +
"        agregador: 'UFJF;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4791540P4',\n" +
"        centralidadeLocal: '0.200806042',\n" +
"        centralidadeGlobal: '0.844057277',\n" +
"        group: '2',\n" +
"        universidade: 'UFJF',\n" +
"        gruposUniversidade: 'UFJF-RJ2'\n" +
"      }\n" +
"},\n" +
"{\n" +
"      id: '100',\n" +
"      label: '100',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#0F0',\n" +
"      data: {\n" +
"        nomeCompleto: 'Joao',\n" +
"        nomeCompletoComEnter: 'Joao',\n" +
"        anoNaRede: '1997',\n" +
"        agregador: 'UFJF;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4791540P4',\n" +
"        centralidadeLocal: '0.200806042',\n" +
"        centralidadeGlobal: '0.844057277',\n" +
"        group: '2',\n" +
"        universidade: 'UFJF',\n" +
"        gruposUniversidade: 'UFJF-RJ2'\n" +
"      }\n" +
"},\n" +
"{\n" +
"      id: '101',\n" +
"      label: '101',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#0F0',\n" +
"      data: {\n" +
"        nomeCompleto: 'Joaquim',\n" +
"        nomeCompletoComEnter: 'Joaquim',\n" +
"        anoNaRede: '1997',\n" +
"        agregador: 'UFJF;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4791540P4',\n" +
"        centralidadeLocal: '0.200806042',\n" +
"        centralidadeGlobal: '0.844057277',\n" +
"        group: '2',\n" +
"        universidade: 'UFJF',\n" +
"        gruposUniversidade: 'UFJF-RJ2'\n" +
"      }\n" +
"},\n" +
"{\n" +
"      id: '102',\n" +
"      label: '102',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#0FF',\n" +
"      data: {\n" +
"        nomeCompleto: 'Antonio',\n" +
"        nomeCompletoComEnter: 'Antonio',\n" +
"        anoNaRede: '1997',\n" +
"        agregador: 'UFMG;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4791540P4',\n" +
"        centralidadeLocal: '0.200806042',\n" +
"        centralidadeGlobal: '0.844057277',\n" +
"        group: '2',\n" +
"        universidade: 'UFMG',\n" +
"        gruposUniversidade: 'UFMG-MG2'\n" +
"      }\n" +
"},\n" +
"{\n" +
"      id: '103',\n" +
"      label: '103',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#0FF',\n" +
"      data: {\n" +
"        nomeCompleto: 'Maria',\n" +
"        nomeCompletoComEnter: 'Maria',\n" +
"        anoNaRede: '1997',\n" +
"        agregador: 'UFMG;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4791540P4',\n" +
"        centralidadeLocal: '0.200806042',\n" +
"        centralidadeGlobal: '0.844057277',\n" +
"        group: '2',\n" +
"        universidade: 'UFMG',\n" +
"        gruposUniversidade: 'UFMG-MG2'\n" +
"      }\n" +
"},\n" +
"{\n" +
"      id: '104',\n" +
"      label: '104',\n" +
"      x: Math.random(),\n" +
"      y: Math.random(),\n" +
"      size: 1,\n" +
"      color: '#0FF',\n" +
"      data: {\n" +
"        nomeCompleto: 'Paula',\n" +
"        nomeCompletoComEnter: 'Paula',\n" +
"        anoNaRede: '1997',\n" +
"        agregador: 'UFMG;2',\n" +
"        nivel: '3',\n" +
"        image: 'http://buscatextual.cnpq.br/buscatextual/servletrecuperafoto?id=K4791540P4',\n" +
"        centralidadeLocal: '0.200806042',\n" +
"        centralidadeGlobal: '0.844057277',\n" +
"        group: '2',\n" +
"        universidade: 'UFMG',\n" +
"        gruposUniversidade: 'UFMG-MG2'\n" +
"      }\n" +
"}\n" +
");\n" +
"\n" +
"    g.edges.push({\n" +
"      id: 'e0',\n" +
"      label: 'Prod. Bibliografica - 1998 - 1.0',\n" +
"      source: '33',\n" +
"      target: '35',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"	{\n" +
"      id: 'e1',\n" +
"      label: 'Prod. Bibliografica - 2004 - 0.4592',\n" +
"      source: '35',\n" +
"      target: '44',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"	{\n" +
"      id: 'e2',\n" +
"      label: 'Prod. Bibliografica - 2004 - 0.4592',\n" +
"      source: '44',\n" +
"      target: '43',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },    \n" +
"	{\n" +
"      id: 'e3',\n" +
"      label: 'Projeto - 2003 - 1',\n" +
"      source: '33',\n" +
"      target: '43',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"	{\n" +
"      id: 'e4',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '35',\n" +
"      target: '43',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"	{\n" +
"      id: 'e5',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '99',\n" +
"      target: '43',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"	{\n" +
"      id: 'e6',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '100',\n" +
"      target: '35',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"	{\n" +
"      id: 'e7',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '101',\n" +
"      target: '35',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"    {\n" +
"      id: 'e9',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '102',\n" +
"      target: '104',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"    {\n" +
"      id: 'e10',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '104',\n" +
"      target: '35',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"    {\n" +
"      id: 'e11',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '100',\n" +
"      target: '103',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"    {\n" +
"      id: 'e12',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '102',\n" +
"      target: '101',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"    {\n" +
"      id: 'e13',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '103',\n" +
"      target: '104',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"    {\n" +
"      id: 'e14',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '100',\n" +
"      target: '99',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"    {\n" +
"      id: 'e15',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '100',\n" +
"      target: '101',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    },\n" +
"    {\n" +
"      id: 'e16',\n" +
"      label: 'Orientacao Concluida - 2003 - 1',\n" +
"      source: '99',\n" +
"      target: '101',\n" +
"      color: '#000',\n" +
"      hover_color: '#FC0',\n" +
"      type: 'line',\n" +
"      size: 1      \n" +
"    }\n" +
"    );\n";
        script += renderizeScript();
        return script;
    }

    /**
     * It renderizes the javascript (linkurious library)
     *
     * @return
     */
    public String renderizeScript() {
        String rend
                = "sigma.renderers.def = sigma.renderers.canvas;\n" +
"\n" +
"// Instantiate sigma:\n" +
"s = new sigma({\n" +
"  graph: g,\n" +
"  renderer: {\n" +
"    container: document.getElementById('graph-container'),\n" +
"    type: 'canvas'\n" +
"  },\n" +
"  settings: {\n" +
"    minNodeSize: 5,\n" +
"    maxNodeSize: 5,\n" +
"    minEdgeSize: 1,\n" +
"    maxEdgeSize: 1,\n" +
"    dragNodeStickiness: 0.01,\n" +
"    nodeBorderSize: 2,\n" +
"    defaultNodeBorderColor: '#000',\n" +
"    enableEdgeHovering: true,\n" +
"    edgeHoverColor: 'edge',\n" +
"    defaultEdgeHoverColor: '#000',\n" +
"    edgeHoverSizeRatio: 1,\n" +
"    edgeHoverExtremities: true,\n" +
"    autoCurveRatio: 2,\n" +
"    edgeHoverHighlightNodes: 'circle',\n" +
"  }\n" +
"});\n" +
"\n" +
"s.refresh();\n" +
"\n" +
"\n" +
"// Instanciate the ActiveState plugin:\n" +
"var activeState = sigma.plugins.activeState(s);\n" +
"\n" +
"// Initialize the dragNodes plugin:\n" +
"var dragListener = sigma.plugins.dragNodes(s, s.renderers[0], activeState);\n" +
"\n" +
"// Initialize the Select plugin:\n" +
"var select = sigma.plugins.select(s, activeState);\n" +
"\n" +
"// Initialize the Keyboard plugin:\n" +
"var keyboard = sigma.plugins.keyboard(s, s.renderers[0]);\n" +
"\n" +
"var config = {\n" +
"  node: [{\n" +
"    show: 'hovers',\n" +
"    hide: 'hovers',\n" +
"    cssClass: 'sigma-tooltip',    \n" +
"    position: 'top',\n" +
"    autoadjust: true,\n" +
"    template:\n" +
"    '<div class=\"arrow\"></div>' +\n" +
"    ' <div class=\"sigma-tooltip-header\">{{label}}</div>' +\n" +
"    '  <div class=\"sigma-tooltip-body\">' +\n" +
"    '    <table>' +\n" +
"    '      <tr><th>Nome Completo</th> <td>{{data.nomeCompleto}}</td></tr>' +\n" +
"    '      <tr><th>Ano na Rede</th> <td>{{data.anoNaRede}}</td></tr>' +\n" +
"	'      <tr><th>Centralidade Local</th> <td>{{data.centralidadeLocal}}</td></tr>' +\n" +
"	'      <tr><th>Centralidade Global</th> <td>{{data.centralidadeGlobal}}</td></tr>' +	\n" +
"	'      <tr><th>Universidade</th> <td>{{data.universidade}}</td></tr>' +\n" +
"    '    </table>' +\n" +
"    '  </div>' +\n" +
"    '  <div class=\"sigma-tooltip-footer\">Number of connections: {{degree}}</div>',\n" +
"    renderer: function(node, template) {\n" +
"      // The function context is s.graph\n" +
"      node.degree = this.degree(node.id);\n" +
"\n" +
"      // Returns an HTML string:\n" +
"      return Mustache.render(template, node);\n" +
"\n" +
"      // Returns a DOM Element:\n" +
"      //var el = document.createElement('div');\n" +
"      //return el.innerHTML = Mustache.render(template, node);\n" +
"    }\n" +
"  }, {\n" +
"    show: 'rightClickNode',\n" +
"    position: 'right',\n" +
"    template:\n" +
"    '<div class=\"arrow\"></div>' +\n" +
"    ' <div class=\"sigma-tooltip-header\">{{label}}</div>' +\n" +
"    '  <div class=\"sigma-tooltip-body\">' +\n" +
"    '   <p> Context menu for {{data.name}} </p>' +\n" +
"    '  </div>' +\n" +
"    ' <div class=\"sigma-tooltip-footer\">Number of connections: {{degree}}</div>',\n" +
"    renderer: function(node, template) {\n" +
"      node.degree = this.degree(node.id);\n" +
"      return Mustache.render(template, node);\n" +
"    }\n" +
"  }],\n" +
"  stage: {\n" +
"    template:\n" +
"    '<div class=\"arrow\"></div>' +\n" +
"    '<div class=\"sigma-tooltip-header\"> Services Analysis </div>'\n" +
"  }\n" +
"};\n" +
"\n" +
//"// Configure the ForceLink algorithm:\n" +
//"var fa = sigma.layouts.configForceLink(s, {\n" +
//"  worker: true,\n" +
//"  barnesHutOptimize: false,\n" +
//"  autoStop: true,\n" +
//"  background: true,\n" +
//"  easing: 'cubicInOut',\n" +
//"  alignNodeSiblings: true,\n" +
//"  nodeSiblingsScale: 1,\n" +
//"  nodeSiblingsAngleMin: 0.3\n" +
//"});\n" +
//"\n" +
//"// Bind the events:\n" +
//"fa.bind('start interpolate stop', function(e) {\n" +
//"  console.log(e.type);\n" +
////"  var el = document.getElementById('notice');\n" +
//"  if (e.type === 'start') {\n" +
//"    el.className = '';\n" +
//"  }\n" +
//"  else if (e.type === 'interpolate') {\n" +
//"    el.className = 'hidden';\n" +
//"  }\n" +
//"});\n" +
//"\n" +
//"// Start the ForceLink algorithm:\n" +
//"sigma.layouts.startForceLink();\n" +
//"\n" +
//"\n" +
//"\n" +
//"\n" +
"// Instanciate the tooltips plugin with a Mustache renderer for node tooltips:\n" +
"var tooltips = sigma.plugins.tooltips(s, s.renderers[0], config);\n" +
"\n" +
"tooltips.bind('shown', function(event) {\n" +
"  console.log('tooltip shown', event);\n" +
"});\n" +
"\n" +
"tooltips.bind('hidden', function(event) {\n" +
"  console.log('tooltip hidden', event);\n" +
"});\n" +
"\n" +
"// Configure the DAG layout:\n"
                + "var dagreListener = sigma.layouts.dagre.configure(s, {\n"
//                + "  directed: true, // take edge direction into account\n"
//                + "  rankdir: 'TB',  // Direction for rank nodes. Can be TB, BT, LR, or RL,\n"
//                + "                  // where T = top, B = bottom, L = left, and R = right.\n"
                + "  easing: 'quadraticInOut', // animation transition function\n"
                + "  duration: 800,   // animation duration\n"
                + "  // nodes : s.graph.nodes().slice(0,30), // subset of nodes\n"
                + "  // boundingBox: {minX: 10, maxX: 20, minY: 10, maxY:20} // constrain layout bounds ; object or true (all current positions of the given nodes)\n"
                + "});\n"
                + "\n"
                + "// Bind the events:\n"
                + "dagreListener.bind('start stop interpolate', function(e) {\n"
                + "  console.log(e.type);\n"
                + "});\n"
                + "\n"
                + "// Start the DAG layout:\n"
                + "sigma.layouts.dagre.start(s);\n"
                + "\n"+
"// Bind the Keyboard plugin to the Select plugin:\n" +
"select.bindKeyboard(keyboard);\n" +
"\n" +
"// Curve parallel edges:\n" +
"sigma.canvas.edges.autoCurve(s);\n" +
"\n" +
"dragListener.bind('startdrag', function(event) {\n" +
"  console.log(event);\n" +
"});\n" +
"dragListener.bind('drag', function(event) {\n" +
"  console.log(event);\n" +
"});\n" +
"dragListener.bind('drop', function(event) {\n" +
"  console.log(event);\n" +
"});\n" +
"dragListener.bind('dragend', function(event) {\n" +
"  console.log(event);\n" +
"});\n" +
"\n" +
"// Bind the events:\n" +
"s.bind('clickNode doubleClickNode rightClickNode', function(e) {\n" +
"  console.log(e.type, e.data.node.label, e.data.captor);\n" +
"});\n" +
"s.bind('clickEdge doubleClickEdge rightClickEdge', function(e) {\n" +
"  console.log(e.type, e.data.edge, e.data.captor);\n" +
"});\n" +
"s.bind('clickStage doubleClickStage rightClickStage', function(e) {\n" +
"  console.log(e.type, e.data.captor);\n" +
"});\n" +
"s.bind('hovers', function(e) {\n" +
"  console.log(e.type, e.data.captor, e.data);\n" +
"});";
        return rend;
    } 
   //--------------------------------------------------------------

    /**
     * It renderizes the javascript (linkurious library)
     *
     * @return
     */
    public String renderizeScriptOntology() {
        String rend
                = "sigma.renderers.def = sigma.renderers.canvas;\n" +
"\n" +
"// Instantiate sigma:\n" +
"s = new sigma({\n" +
"  graph: g,\n" +
"  renderer: {\n" +
"    container: document.getElementById('graph-container'),\n" +
"    type: 'canvas'\n" +
"  },\n" +
"  settings: {\n" +
"    minNodeSize: 5,\n" +
"    maxNodeSize: 5,\n" +
"    minEdgeSize: 1,\n" +
"    maxEdgeSize: 1,\n" +
"    minArrowSize: 10, \n" +
"    maxArrowSize: 50, \n" +                
"    dragNodeStickiness: 0.01,\n" +
"    nodeBorderSize: 2,\n" +
"    defaultNodeBorderColor: '#000000',\n" +
"    enableEdgeHovering: true,\n" +
"    edgeHoverColor: 'edge',\n" +
"    defaultEdgeHoverColor: '#000000',\n" +
"    edgeHoverSizeRatio: 1,\n" +
"    edgeHoverExtremities: true,\n" +
"    autoCurveRatio: 2,\n" +
"    edgeHoverHighlightNodes: 'circle',\n" +
"  }\n" +
"});\n" +
"\n" +
"s.refresh();\n" +
"\n" +
"// Instanciate the ActiveState plugin:\n" +
"var activeState = sigma.plugins.activeState(s);\n" +
"\n" +
"// Initialize the dragNodes plugin:\n" +
"var dragListener = sigma.plugins.dragNodes(s, s.renderers[0], activeState);\n" +
"\n" +
"// Initialize the Select plugin:\n" +
"var select = sigma.plugins.select(s, activeState);\n" +
"\n" +
"// Initialize the Keyboard plugin:\n" +
"var keyboard = sigma.plugins.keyboard(s, s.renderers[0]);\n" +
"\n" +
                //Configuração dos nós-------
"var config = {\n" +
"  node: [{\n" +
"    show: 'rightClickNode',\n" +
"    cssClass: 'sigma-tooltip',    \n" +                
"    position: 'right',\n" +                
"    template:\n" +
"    '<div class=\"arrow\"></div>' +\n" +
"    ' <div class=\"sigma-tooltip-header\">id: {{label}}</div>' +\n" +
"    '  <div class=\"sigma-tooltip-body\">' +\n" +
"    '   <p> Ontology Class: {{data.name}} </p>' +\n" +
"    '  </div>' +\n" +
"    ' <div class=\"sigma-tooltip-footer\">Number of connections: {{degree}}</div>',\n" +
"    renderer: function(node, template) {\n" +
"      node.degree = this.degree(node.id);\n" +
"      return Mustache.render(template, node);\n" +
"    }\n" +
"  }],\n" +
"  stage: {\n" +
"    template:\n" +
"    '<div class=\"arrow\"></div>' +\n" +
"    '<div class=\"sigma-tooltip-header\"> Ontology </div>'\n" +
"  }\n" +
"};\n" +
"\n" +
"\n" +

"// Configure the ForceLink algorithm:\n" +
"var fa = sigma.layouts.configForceLink(s, {\n" +
"  worker: true,\n" +
"  barnesHutOptimize: false,\n" +
"  autoStop: true,\n" +
"  background: true,\n" +
"  easing: 'cubicInOut',\n" +
"  alignNodeSiblings: true,\n" +
"  nodeSiblingsScale: 1,\n" +
"  nodeSiblingsAngleMin: 0.3\n" +
"});\n" +
"\n" +
"// Bind the events:\n" +
"fa.bind('start interpolate stop', function(e) {\n" +
"  console.log(e.type);\n" +
//"  var el = document.getElementById('notice');\n" +
"  if (e.type === 'start') {\n" +
"    el.className = '';\n" +
"  }\n" +
"  else if (e.type === 'interpolate') {\n" +
"    el.className = 'hidden';\n" +
"  }\n" +
"});\n" +
"\n" +
"// Start the ForceLink algorithm:\n" +
"sigma.layouts.startForceLink();\n" +
                
"// Instanciate the tooltips plugin with a Mustache renderer for node tooltips:\n" +
"var tooltips = sigma.plugins.tooltips(s, s.renderers[0], config);\n" +
"\n" +
"tooltips.bind('shown', function(event) {\n" +
"  console.log('tooltip shown', event);\n" +
"});\n" +
"\n" +
"tooltips.bind('hidden', function(event) {\n" +
"  console.log('tooltip hidden', event);\n" +
"});\n" +
"\n" +
"// Configure the DAG layout:\n"
                + "var dagreListener = sigma.layouts.dagre.configure(s, {\n"
                + "  directed: true, // take edge direction into account\n"
                + "  rankdir: 'LR',  // Direction for rank nodes. Can be TB, BT, LR, or RL,\n"
                + "                  // where T = top, B = bottom, L = left, and R = right.\n"
                + "  easing: 'quadraticInOut', // animation transition function\n"
                + "  duration: 800,   // animation duration\n"
                + "  // nodes : s.graph.nodes().slice(0,30), // subset of nodes\n"
                + "  // boundingBox: {minX: 10, maxX: 20, minY: 10, maxY:20} // constrain layout bounds ; object or true (all current positions of the given nodes)\n"
                + "});\n"
                + "\n"
                + "// Bind the events:\n"
                + "dagreListener.bind('start stop interpolate', function(e) {\n"
                + "  console.log(e.type);\n"
                + "});\n"
                + "\n"
                + "// Start the DAG layout:\n"
                + "sigma.layouts.dagre.start(s);\n"
                + "\n"+                
"// Bind the Keyboard plugin to the Select plugin:\n" +
"select.bindKeyboard(keyboard);\n" +
"\n" +
"// Curve parallel edges:\n" +
"sigma.canvas.edges.autoCurve(s);\n" +
"\n" +
"dragListener.bind('startdrag', function(event) {\n" +
"  console.log(event);\n" +
"});\n" +
"dragListener.bind('drag', function(event) {\n" +
"  console.log(event);\n" +
"});\n" +
"dragListener.bind('drop', function(event) {\n" +
"  console.log(event);\n" +
"});\n" +
"dragListener.bind('dragend', function(event) {\n" +
"  console.log(event);\n" +
"});\n" +
"\n" +
"// Bind the events:\n" +
"s.bind('clickNode doubleClickNode rightClickNode', function(e) {\n" +
"  console.log(e.type, e.data.node.label, e.data.captor);\n" +
"});\n" +
"s.bind('clickEdge doubleClickEdge rightClickEdge', function(e) {\n" +
"  console.log(e.type, e.data.edge, e.data.captor);\n" +
"});\n" +
"s.bind('clickStage doubleClickStage rightClickStage', function(e) {\n" +
"  console.log(e.type, e.data.captor);\n" +
"});\n" +
"s.bind('hovers', function(e) {\n" +
"  console.log(e.type, e.data.captor, e.data);\n" +
"});";
        return rend;
    }
    
    public String OntologyGenerator(int type) throws ParserConfigurationException, SAXException{
        
        String script = "";
        
        try {
            URL url = new URL("http://localhost:8080/visualizacao_semantica_estrutural/resources/exportaOntologia/"+type);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/plain");
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = "", captura;
            captura = br.readLine();
            while (captura != null) {
		output+=captura;
                output+="\n";
                captura = br.readLine();
            }
     
            conn.disconnect();

            script = output;
            
            }catch (MalformedURLException e) {
            }catch (IOException e) {
        }
        
        script += renderizeScriptOntology();
        return script;
    }
}