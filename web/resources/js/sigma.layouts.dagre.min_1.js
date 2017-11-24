(function(a){"use strict";function b(a,b){var c,d,b=b||"",e=-(1/0),f=1/0,g=1/0,h=-(1/0),i=-(1/0);for(c=0,d=a.length;d>c;c++)e=Math.max(a[c][b+"size"],e),h=Math.max(a[c][b+"x"],h),f=Math.min(a[c][b+"x"],f),i=Math.max(a[c][b+"y"],i),g=Math.min(a[c][b+"y"],g);return e=e||1,{sizeMax:e,minX:f,minY:g,maxX:h,maxY:i}}function c(a,b,c,d,e){return(e-d)*(a-b)/(c-b)+d}function d(a,b,d){return{x:c(a.x,b.minX,b.maxX,d.minX,d.maxX),y:c(a.y,b.minY,b.maxY,d.minY,d.maxY)}}function e(){if("undefined"==typeof dagre)throw new Error("dagre is not declared");if("undefined"==typeof dagre.graphlib)throw new Error("dagre.graphlib is not declared");var a,c=this;this.init=function(a,b){if(b=b||{},b.nodes&&(this.nodes=b.nodes,delete b.nodes),b.boundingBox&&(this.boundingBox=b.boundingBox,delete b.boundingBox),this.sigInst=a,this.config=sigma.utils.extend(b,f),this.easing=b.easing,this.duration=b.duration,this.easing&&(!sigma.plugins||"undefined"==typeof sigma.plugins.animate))throw new Error("sigma.plugins.animate is not declared");this.running=!1},this.start=function(){if(!this.running){this.running=!0,a=new dagre.graphlib.Graph({directed:this.config.directed,multigraph:this.config.multigraph,compound:this.config.compound}),a.setGraph(this.config);for(var d=this.nodes||this.sigInst.graph.nodes(),e=0;e<d.length;e++)d[e].fixed||a.setNode(d[e].id,{});this.boundingBox===!0&&(this.boundingBox=b(d));for(var f=this.sigInst.graph.edges(),e=0;e<f.length;e++)null!=a.node(f[e].source)&&null!=a.node(f[e].target)&&a.setEdge(f[e].source,f[e].target,{id:f[e].id});h[c.sigInst.id].dispatchEvent("start"),dagre.layout(a);var g;a.edges().map(function(b){g=c.sigInst.graph.edges(a.edge(b).id),g.points=a.edge(b).points}),this.stop()}},this.stop=function(){if(a){var e,f=a.nodes().map(function(a){return c.sigInst.graph.nodes(a)||c.sigInst.graph.nodes(Number(a))});if(this.boundingBox)var g=b(a.nodes().map(function(b){return a.node(b)}));if(this.running=!1,this.easing){for(var i=0;i<f.length;i++)this.boundingBox?(e=d(a.node(f[i].id),g,c.boundingBox),f[i].dagre_x=e.x,f[i].dagre_y=e.y):(f[i].dagre_x=a.node(f[i].id).x,f[i].dagre_y=a.node(f[i].id).y);h[c.sigInst.id].dispatchEvent("interpolate"),sigma.plugins.animate(c.sigInst,{x:"dagre_x",y:"dagre_y"},{nodes:f,easing:c.easing,onComplete:function(){for(var a=0;a<f.length;a++)f[a].dagre_x=null,f[a].dagre_y=null;h[c.sigInst.id].dispatchEvent("stop"),c.sigInst.refresh()},duration:c.duration})}else{var j;a.nodes().forEach(function(b){j=c.sigInst.graph.nodes(b),j.x=a.node(b).x,j.y=a.node(b).y}),h[c.sigInst.id].dispatchEvent("stop"),this.sigInst.refresh()}}},this.kill=function(){this.sigInst=null,this.config=null,this.easing=null}}if("undefined"==typeof sigma)throw new Error("sigma is not declared");("undefined"==typeof dagre||"undefined"==typeof dagre.graphlib)&&console.warn("to use the dagre plugin, you have to include dagre and dagre.graphlib"),sigma.utils.pkg("sigma.layouts.dagre");var f={directed:!0,multigraph:!0,compound:!1,rankDir:"TB"},g={},h={};sigma.layouts.dagre.configure=function(a,b){if(!a)throw new Error('Missing argument: "sigInst"');if(!b)throw new Error('Missing argument: "config"');return g[a.id]||(g[a.id]=new e,h[a.id]={},sigma.classes.dispatcher.extend(h[a.id]),a.bind("kill",function(){g[a.id].kill(),g[a.id]=null,h[a.id]=null})),g[a.id].init(a,b),h[a.id]},sigma.layouts.dagre.start=function(a,b){if(!a)throw new Error('Missing argument: "sigInst"');return b&&this.configure(a,b),g[a.id].start(),h[a.id]},sigma.layouts.dagre.isRunning=function(a){if(!a)throw new Error('Missing argument: "sigInst"');return!!g[a.id]&&g[a.id].running}}).call(this);
//# sourceMappingURL=sigma.layouts.dagre.min.js.map