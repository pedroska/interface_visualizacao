(function(undefined){"use strict";function strToObjectRef(a,b){return b.split(".").reduce(function(a,b){return a[b]},a)}function emptyObject(a){var b;for(b in a)"hasOwnProperty"in a&&!a.hasOwnProperty(b)||delete a[b];return a}function deepCopy(o){var copy=Object.create(null);for(var i in o)"object"==typeof o[i]&&null!==o[i]?copy[i]=deepCopy(o[i]):"function"==typeof o[i]&&null!==o[i]?eval(" copy[i] = "+o[i].toString()):copy[i]=o[i];return copy}function baseHistogram(a,b){var c,d,e,f,g={};return a.length?(c=a.map(function(a){return parseFloat(a)}).sort(function(a,b){return a-b}),d=c[0],e=c[c.length-1],e-d!==0?c.forEach(function(a){f=Math.floor(b*Math.abs(a-d)/Math.abs(e-d)),f-=f==b?1:0,g[a]=f}):c.forEach(function(a){g[a]=0}),g):g}function histogram(a,b){var c,d=[],e=0;if(a&&a[b]){Object.keys(a[b]).forEach(function(c){var e=a[b][c];d[e]=d[e]||[],d[e].push(+c)}),c=1!==d.length?d.length:7;for(var f=0;c>f;f++)d[f]&&(e=e>d[f].length?e:d[f].length);for(var f=0;c>f;f++)d[f]===undefined&&(d[f]=[]),d[f]={bin:f,values:d[f],ratio:d[f].length/e},d[f].values.length&&(d[f].min=Math.min.apply(null,d[f].values),d[f].max=Math.max.apply(null,d[f].values))}return d}function resolveHistogram(a,b,c){for(var d,e=b.get(c),f=a.length,g=0,h=0;f>h;h++)a[h].items=[];Object.keys(e).forEach(function(b){for(var f=0;f<e[b].items.length;f++){d=e[b].items[f],b=strToObjectRef(d,c);for(var g=0;g<a.length;g++)!1 in a[g]||!1 in a[g]||a[g].min<=b&&b<=a[g].max&&a[g].items.push(d)}});for(var h=0;f>h;h++)a[h].items&&(g=g>a[h].items.length?g:a[h].items.length);for(var h=0;f>h;h++)a[h].itemsRatio=a[h].items.length/g;return a}function download(a,b,c){var d=null,e=null,f=null;if(window.Blob?(d=new Blob([a],{type:"text/json"}),e=window.URL.createObjectURL(d)):f="data:text/json;charset=UTF-8,"+encodeURIComponent(a),navigator.msSaveBlob)navigator.msSaveBlob(d,c);else if(navigator.msSaveOrOpenBlob)navigator.msSaveOrOpenBlob(d,c);else{var g=document.createElement("a");g.setAttribute("href",window.Blob?e:f),g.setAttribute("download",c||"graph."+b),document.body.appendChild(g),g.click(),document.body.removeChild(g)}e&&setTimeout(function(){window.URL.revokeObjectURL(e)},0)}function Vision(a,b,c,d){var e=this;if(this.visualVars=null,this.mappings=null,this.palette=d,this.idx=Object.create(null),this.histograms=Object.create(null),this.deprecated=Object.create(null),this.sigmaSettings=Object.create(null),this.dataTypes=Object.create(null),this.originalVisualVariable=Object.create(null),"nodes"===b)this.visualVars=["color","size","label","type","icon","image"],this.mappings=c.nodes,this.dataset=function(){return a.graph.nodes()};else{if("edges"!==b)throw new Error('Invalid argument: "datasetName" is not "nodes" or "edges", was '+b);this.visualVars=["color","size","label","type"],this.mappings=c.edges,this.dataset=function(){return a.graph.edges()}}return this.update=function(a){function b(b,d){c.idx[a][b]===undefined&&(c.idx[a][b]={key:b,items:[],styles:Object.create(null)}),c.idx[a][b].items.push(d),(h||h===undefined)&&(h="number"==typeof b)}var c=this;if(a===undefined)throw new Error('Missing argument: "key".');if("string"!=typeof a)throw new Error('Invalid argument: "key" is not a string, was '+a);var d,f,g,h=undefined,i=!0;f=function(a,b){return strToObjectRef(a,b)},g=function(a,b){return strToObjectRef(a,b)},this.idx[a]={},this.dataset().forEach(function(c){d=f(c,a),d!==undefined&&(i&&(i=Array.isArray(d)?i:!1),i?1===d.length?b(d[0],c):d.forEach(function(a){b(a,c)}):b(d,c))}),this.dataTypes[a]={sequential:h,array:i},this.deprecated[a]=!1;var j=0;for(d in this.idx[a])j=j<this.idx[a][d].items.length?this.idx[a][d].items.length:j;Object.keys(this.idx[a]).forEach(function(b){c.idx[a][b].ratio=parseFloat(c.idx[a][b].items.length/j)});var k,l,m,n,o,p,q,r=0;q=Object.keys(e.mappings).filter(function(b){return e.mappings[b]&&e.mappings[b].by!==undefined&&e.mappings[b].by.toString()==a}),q.forEach(function(b){switch(b){case"color":if(l=e.mappings.color.scheme,"string"!=typeof l)throw new Error('color.scheme "'+l+'" is not a string.');h&&(p=e.mappings.color.bins||7,c.histograms.color=c.histograms.color||{},c.histograms.color[a]=baseHistogram(Object.keys(c.idx[a]),p));break;case"label":if(k=e.mappings.label.format||function(a){return"string"==typeof a?a:a.label},"function"!=typeof k)throw new Error('label.format "'+k+'" is not a function.');break;case"size":if(h===undefined)break;if(!h)throw new Error('One value of the property "'+a+'" is not a number.');c.histograms.size=c.histograms.size||{},c.histograms.size[a]=baseHistogram(Object.keys(c.idx[a]),e.mappings.size.bins||7);break;case"type":if(m=e.mappings.type.scheme,"string"!=typeof m)throw new Error('type.scheme "'+m+'" is not a string.');break;case"icon":if(n=e.mappings.icon.scheme,"string"!=typeof n)throw new Error('icon.scheme "'+n+'" is not a string.');break;case"image":if(o=e.mappings.image.scheme,"string"!=typeof o)throw new Error('type.scheme "'+o+'" is not a string.')}}),Object.keys(this.idx[a]).forEach(function(b){q.forEach(function(d){switch(d){case"color":h?c.idx[a][b].styles.color=function(){var d=c.histograms.color[a][b];return g(e.palette,l)[p][d]}:c.idx[a][b].styles.color=function(){if(g(e.palette,l)===undefined)throw new Error("Wrong or undefined color scheme.");if(e.mappings.color.set>0){var a=g(e.palette,l)[e.mappings.color.set][r];return r=(r+1)%e.mappings.color.set,a}return g(e.palette,l)[b]};break;case"label":c.idx[a][b].styles.label=function(b){return k(f(b,a))};break;case"size":c.idx[a][b].styles.size=function(){return 1+c.histograms.size[a][b]};break;case"type":c.idx[a][b].styles.type=function(){if(g(e.palette,m)===undefined)throw new Error("Wrong or undefined type scheme.");return g(e.palette,m)[b]};break;case"icon":c.idx[a][b].styles.icon=function(){if(g(e.palette,n)===undefined)throw new Error("Wrong or undefined icon scheme.");return g(e.palette,n)[b]};break;case"image":c.idx[a][b].styles.image=function(){if(g(e.palette,o)===undefined)throw new Error("Wrong or undefined image scheme.");return g(e.palette,o)[b]}}})})},this.get=function(a){if(a===undefined)throw new TypeError('Missing argument: "key".');if("string"!=typeof a)throw new TypeError('Invalid argument: "key" is not a string, was '+a);return this.deprecated[a]&&this.update(a),this.idx[a]===undefined&&this.update(a),this.idx[a]},this.applyStyle=function(c,d){if(d===undefined)throw new TypeError('Missing argument: "key"');if("string"!=typeof d)throw new TypeError('Invalid argument: "key" is not a string, was '+d);if(-1==this.visualVars.indexOf(c))throw new Error('Unknown style "'+c+'"');var e=this,f=this.get(d);if("color"===c&&e.dataTypes[d].array&&(this.dataset().forEach(function(a){delete a.colors}),Object.keys(f).forEach(function(a){var b=f[a];b.items.forEach(function(a){a.colors=[]})})),Object.keys(f).forEach(function(a){var b=f[a];b.items.forEach(function(a){if(a!==undefined&&b.styles!==undefined&&"function"==typeof b.styles[c]){e.originalVisualVariable[a.id]||(e.originalVisualVariable[a.id]={}),c in e.originalVisualVariable[a.id]||Object.defineProperty(e.originalVisualVariable[a.id],c,{enumerable:!0,value:a[c]});var f=b.styles[c](a);"color"===c&&e.dataTypes[d].array?f!==undefined&&(a.color=f,a.colors.push(f)):f!==undefined&&(a[c]=f)}else if("function"==typeof b.styles[c])throw new TypeError(b.styles+"."+c+"is not a function, was "+b.styles[c])})}),"size"===c)if("nodes"===b){if(this.mappings.size.min>this.mappings.size.max)throw new RangeError("nodes.size.min must be lower or equal than nodes.size.max");this.mappings.size.min&&(this.sigmaSettings.minNodeSize||(this.sigmaSettings.minNodeSize=a.settings("minNodeSize")),a.settings("minNodeSize",this.mappings.size.min)),this.mappings.size.max&&(this.sigmaSettings.maxNodeSize||(this.sigmaSettings.maxNodeSize=a.settings("maxNodeSize")),a.settings("maxNodeSize",this.mappings.size.max))}else if("edges"===b){if(this.mappings.size.min>this.mappings.size.max)throw new RangeError("edges.size.min must be lower or equal than edges.size.max");this.mappings.size.min&&(this.sigmaSettings.minEdgeSize||(this.sigmaSettings.minEdgeSize=a.settings("minEdgeSize")),a.settings("minEdgeSize",this.mappings.size.min)),this.mappings.size.max&&(this.sigmaSettings.maxEdgeSize||(this.sigmaSettings.maxEdgeSize=a.settings("maxEdgeSize")),a.settings("maxEdgeSize",this.mappings.size.max))}},this.resetStyle=function(c,d){if(d===undefined)throw new TypeError('Missing argument: "key"');if("string"!=typeof d)throw new TypeError('Invalid argument: "key" is not a string, was '+d);if(-1==this.visualVars.indexOf(c))throw new Error('Unknown style "'+c+'".');if(this.idx[d]!==undefined){var e=this,f=this.get(d);"color"===c&&e.dataTypes[d].array&&Object.keys(f).forEach(function(a){var b=f[a];b.items.forEach(function(a){delete a.colors})}),Object.keys(f).forEach(function(a){var b=f[a];b.items.forEach(function(a){a!==undefined&&a[c]!==undefined&&(e.originalVisualVariable[a.id]===undefined||e.originalVisualVariable[a.id][c]===undefined?"edges"===e.key&&"size"===c?a.size=1:delete a[c]:a[c]=e.originalVisualVariable[a.id][c])})}),"size"===c&&("nodes"===b?(this.sigmaSettings.minNodeSize&&a.settings("minNodeSize",this.sigmaSettings.minNodeSize),this.sigmaSettings.maxNodeSize&&a.settings("maxNodeSize",this.sigmaSettings.maxNodeSize)):"edges"===b&&(this.sigmaSettings.minEdgeSize&&a.settings("minEdgeSize",this.sigmaSettings.minEdgeSize),this.sigmaSettings.maxEdgeSize&&a.settings("maxEdgeSize",this.sigmaSettings.maxEdgeSize)))}},this.clear=function(){this.visualVars.length=0,emptyObject(this.idx),emptyObject(this.histograms),emptyObject(this.deprecated),emptyObject(this.sigmaSettings),emptyObject(this.dataTypes),emptyObject(this.originalVisualVariable)},this}function design(a,b){function c(b,c,d){d?b[d]&&b[d].by&&(c.applyStyle(d,b[d].by),b[d].active=!0):Object.keys(b).forEach(function(a){b[a].active=!1,b[a]&&b[a].by&&(c.applyStyle(a,b[a].by),b[a].active=!0)}),a&&a.refresh({skipIndexation:!0})}function d(b,c,d){d?b[d]&&b[d].active&&(c.resetStyle(d,b[d].by),b[d].active=!1):Object.keys(b).forEach(function(a){b[a].active&&(c.resetStyle(a,b[a].by),b[a].active=!1)}),a&&a.refresh({skipIndexation:!0})}this.palette=(b||{}).palette||{},this.styles=sigma.utils.extend((b||{}).styles||{},{nodes:{},edges:{}});var e=this,f=new Vision(a,"nodes",this.styles,this.palette),g=new Vision(a,"edges",this.styles,this.palette);a.bind("kill",function(){sigma.plugins.killDesign(a)}),this.setStyles=function(a){return this.styles=sigma.utils.extend(a||{},{nodes:{},edges:{}}),f.mappings=this.styles.nodes,g.mappings=this.styles.edges,this.deprecate(),this},this.nodesBy=function(a,b){return this.styles=sigma.utils.extend(this.styles||{},{nodes:{},edges:{}}),this.styles.nodes[a]=b,f.mappings=this.styles.nodes,b.by&&this.deprecate("nodes",b.by),this},this.edgesBy=function(a,b){return this.styles=sigma.utils.extend(this.styles||{},{nodes:{},edges:{}}),this.styles.edges[a]=b,g.mappings=this.styles.edges,b.by&&this.deprecate("edges",b.by),this},this.setPalette=function(a){return this.palette=a,f.palette=this.palette,g.palette=this.palette,this.deprecate(),this},this.nodes=function(a){return f.get(a)},this.edges=function(a){return g.get(a)},this.inspect=function(){return{nodes:deepCopy(f),edges:deepCopy(g)}},this.apply=function(a,b){if(this.styles){if(!a)return c(this.styles.nodes,f,b),c(this.styles.edges,g,b),this;switch(a){case"nodes":c(this.styles.nodes,f,b);break;case"edges":c(this.styles.edges,g,b);break;default:throw new Error('Invalid argument: "target" is not "nodes" or "edges", was '+a)}return this}},this.reset=function(a,b){if(this.styles){if(!a)return d(this.styles.nodes,f,b),d(this.styles.edges,g,b),this;switch(a){case"nodes":d(this.styles.nodes,f,b);break;case"edges":d(this.styles.edges,g,b);break;default:throw new Error('Invalid argument: "target" is not "nodes" or "edges", was '+a)}return this}},this.deprecate=function(a,b){if(a){if("nodes"!==a&&"edges"!==a)throw new Error('Invalid argument: "target" is not "nodes" or "edges", was '+a);b?"nodes"===a?f.deprecated[b]=!0:"edges"===a&&(g.deprecated[b]=!0):"nodes"===a?Object.keys(f.deprecated).forEach(function(a){f.deprecated[a]=!0}):"edges"===a&&Object.keys(g.deprecated).forEach(function(a){g.deprecated[a]=!0})}else Object.keys(f.deprecated).forEach(function(a){f.deprecated[a]=!0}),Object.keys(g.deprecated).forEach(function(a){g.deprecated[a]=!0});return this},this.deletePropertyStylesFrom=function(a,b,c){if(null==b)throw new TypeError('Missing argument: "id".');if("nodes"!==a&&"edges"!==a)throw new Error('Invalid argument: "target" is not "nodes" or "edges", was '+a);if(null==c)throw new TypeError('Missing argument: "key".');var d,e,h,i;d="nodes"===a?f.get(c):g.get(c);for(var j=Object.keys(d),k=0;k<j.length;k++){e=d[j[k]],h=Object.keys(e.styles);for(var l=0;l<e.items.length;l++)if(i=e.items[l],i.id===b){for(var m=0;m<h.length;m++)"label"!==h[m]&&"size"!==h[m]?delete i[h[m]]:"size"===h[m]&&(i.size=1);return this.deprecate(a,c),this}}return this},this.clear=function(){return this.reset(),this.styles={nodes:{},edges:{}},this.palette={},f.clear(),g.clear(),f=new Vision(a,"nodes",this.styles,this.palette),g=new Vision(a,"edges",this.styles,this.palette),a&&a.refresh({skipIndexation:!0}),this},this.kill=function(){delete this.styles,delete this.palette,f.clear(),g.clear()},this.toJSON=function(a){a=a||{};var b={styles:this.styles,palette:this.palette};if(a.pretty)var c=JSON.stringify(b,null," ");else var c=JSON.stringify(b);return a.download&&download(c,"json",a.filename),c},this.utils={},this.utils.isSequential=function(a,b){if(!a)throw new TypeError('Missing argument: "target"');var c;switch(a){case"nodes":c=f;break;case"edges":c=g;break;default:throw new Error('Invalid argument: "target" is not "nodes" or "edges", was '+a)}if(b===undefined)throw new TypeError('Missing argument: "property"');if("string"!=typeof b)throw new TypeError('Invalid argument: "property" is not a string, was '+b);if(!(b in c.dataTypes)||c.dataTypes[b].sequential===undefined){var d,e=!1,h=!0;c.dataset().forEach(function(a){d=strToObjectRef(a,b),d!==undefined&&(e=!0,h="number"==typeof d?h:!1)}),e?c.dataTypes[b]={sequential:h}:c.dataTypes[b]&&(c.dataTypes[b].sequential=undefined)}return(c.dataTypes[b]||{}).sequential},this.utils.histogram=function(a,b,c){if(!a)throw new TypeError('Missing argument: "target"');var d;switch(a){case"nodes":d=f;break;case"edges":d=g;break;default:throw new Error('Invalid argument: "target" is not "nodes" or "edges", was '+a)}if(-1==d.visualVars.indexOf(b))throw new Error('Unknown visual variable "'+b+'".');if(c===undefined)throw new TypeError('Missing argument: "property".');if("string"!=typeof c)throw new TypeError('Invalid argument: "property" is not a string, was'+c);var h=e.utils.isSequential(a,c);if(!h)throw new Error('The property "'+c+'" is not sequential.');var i=histogram(d.histograms[b],c);if(i=resolveHistogram(i,d,c),"color"===b){if(!e.styles[a].color)throw new Error('Missing key "color" in '+a+" palette.");var j=i.length,k=strToObjectRef(e.palette,e.styles[a].color.scheme);if(!k)throw new Error('Color scheme "'+e.styles[a].color.scheme+'" not in '+a+" palette.");if(h)for(var l=0;j>l;l++){if(!k[j])throw new Error('Missing key "'+j+'" in '+a+' palette " of color scheme '+e.styles[a].color.scheme+'".');i[l][b]=k[j][l]}}return i}}if("undefined"==typeof sigma)throw new Error("sigma is not declared");sigma.utils.pkg("sigma.plugins");var _instance={};sigma.plugins.design=function(a,b){return _instance[a.id]||(_instance[a.id]=new design(a,b)),_instance[a.id]},sigma.plugins.killDesign=function(a){_instance[a.id]instanceof design&&_instance[a.id].kill(),delete _instance[a.id]}}).call(this);
//# sourceMappingURL=sigma.plugins.design.min.js.map