(function(undefined){"use strict";function download(a,b,c){var d=null,e=null,f=null;if(window.Blob?(d=new Blob([a],{type:"text/json"}),e=window.URL.createObjectURL(d)):f="data:text/json;charset=UTF-8,"+encodeURIComponent(a),navigator.msSaveBlob)navigator.msSaveBlob(d,c);else if(navigator.msSaveOrOpenBlob)navigator.msSaveOrOpenBlob(d,c);else{var g=document.createElement("a");g.setAttribute("href",window.Blob?e:f),g.setAttribute("download",c||"graph."+b),document.body.appendChild(g),g.click(),document.body.removeChild(g)}e&&setTimeout(function(){window.URL.revokeObjectURL(e)},0)}function deepCopy(o){var copy=Object.create(null);for(var i in o)"object"==typeof o[i]&&null!==o[i]?copy[i]=deepCopy(o[i]):"function"==typeof o[i]&&null!==o[i]?eval(" copy[i] = "+o[i].toString()):copy[i]=o[i];return copy}function startsWith(a,b){return b.slice(0,a.length)==a}function cleanup(a){for(var b in a)(startsWith("read_cam",b)||startsWith("cam",b)||startsWith("renderer",""+b))&&(a[b]=undefined);return a}if("undefined"==typeof sigma)throw"sigma.exporters.json: sigma is not declared";sigma.prototype.toJSON=function(a){a=a||{};var b={nodes:this.graph.nodes().map(deepCopy).map(cleanup),edges:this.graph.edges().map(deepCopy).map(cleanup)};if(a.pretty)var c=JSON.stringify(b,null," ");else var c=JSON.stringify(b);return a.download&&download(c,"json",a.filename),c}}).call(this);
//# sourceMappingURL=sigma.exporters.json.min.js.map