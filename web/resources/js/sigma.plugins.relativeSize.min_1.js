(function(){"use strict";if("undefined"==typeof sigma)throw"sigma is not declared";sigma.utils.pkg("sigma.plugins");sigma.plugins.relativeSize=function(a,b){for(var c=a.graph.nodes(),d=0;d<c.length;d++){var e=a.graph.degree(c[d].id);c[d].size=b*Math.sqrt(e)}a.refresh()}}).call(window);
//# sourceMappingURL=sigma.plugins.relativeSize.min.js.map