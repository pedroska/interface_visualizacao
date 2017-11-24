!function(){"use strict";sigma.utils.pkg("sigma.canvas.edgehovers"),sigma.canvas.edgehovers.dashed=function(a,b,c,d,e){var f=a.active?a.active_color||e("defaultEdgeActiveColor"):a.color,g=e("prefix")||"",h=a[g+"size"]||1,i=e("edgeColor"),j=e("defaultNodeColor"),k=e("defaultEdgeColor"),l=e("edgeHoverLevel");if(!f)switch(i){case"source":f=b.color||j;break;case"target":f=c.color||j;break;default:f=k}if(f="edge"===e("edgeHoverColor")?a.hover_color||f:a.hover_color||e("defaultEdgeHoverColor")||f,h*=e("edgeHoverSizeRatio"),d.save(),l)switch(d.shadowOffsetX=0,l){case 1:d.shadowOffsetY=1.5,d.shadowBlur=4,d.shadowColor="rgba(0,0,0,0.36)";break;case 2:d.shadowOffsetY=3,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.39)";break;case 3:d.shadowOffsetY=6,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.42)";break;case 4:d.shadowOffsetY=10,d.shadowBlur=20,d.shadowColor="rgba(0,0,0,0.47)";break;case 5:d.shadowOffsetY=15,d.shadowBlur=24,d.shadowColor="rgba(0,0,0,0.52)"}d.setLineDash([8,3]),d.strokeStyle=f,d.lineWidth=h,d.beginPath(),d.moveTo(b[g+"x"],b[g+"y"]),d.lineTo(c[g+"x"],c[g+"y"]),d.stroke(),l&&(d.shadowOffsetY=0,d.shadowBlur=0,d.shadowColor="#000000"),d.restore(),sigma.canvas.edges.labels&&(a.hover=!0,sigma.canvas.edges.labels.def(a,b,c,d,e),a.hover=!1)}}(),function(){"use strict";sigma.utils.pkg("sigma.canvas.edgehovers"),sigma.canvas.edgehovers.dotted=function(a,b,c,d,e){var f=a.active?a.active_color||e("defaultEdgeActiveColor"):a.color,g=e("prefix")||"",h=a[g+"size"]||1,i=e("edgeColor"),j=e("defaultNodeColor"),k=e("defaultEdgeColor"),l=e("edgeHoverLevel");if(!f)switch(i){case"source":f=b.color||j;break;case"target":f=c.color||j;break;default:f=k}if(f="edge"===e("edgeHoverColor")?a.hover_color||f:a.hover_color||e("defaultEdgeHoverColor")||f,h*=e("edgeHoverSizeRatio"),d.save(),l)switch(d.shadowOffsetX=0,l){case 1:d.shadowOffsetY=1.5,d.shadowBlur=4,d.shadowColor="rgba(0,0,0,0.36)";break;case 2:d.shadowOffsetY=3,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.39)";break;case 3:d.shadowOffsetY=6,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.42)";break;case 4:d.shadowOffsetY=10,d.shadowBlur=20,d.shadowColor="rgba(0,0,0,0.47)";break;case 5:d.shadowOffsetY=15,d.shadowBlur=24,d.shadowColor="rgba(0,0,0,0.52)"}d.setLineDash([2]),d.strokeStyle=f,d.lineWidth=h,d.beginPath(),d.moveTo(b[g+"x"],b[g+"y"]),d.lineTo(c[g+"x"],c[g+"y"]),d.stroke(),l&&(d.shadowOffsetY=0,d.shadowBlur=0,d.shadowColor="#000000"),d.restore(),sigma.canvas.edges.labels&&(a.hover=!0,sigma.canvas.edges.labels.def(a,b,c,d,e),a.hover=!1)}}(),function(){"use strict";sigma.utils.pkg("sigma.canvas.edgehovers"),sigma.canvas.edgehovers.parallel=function(a,b,c,d,e){var f,g,h=a.active?a.active_color||e("defaultEdgeActiveColor"):a.color,i=e("prefix")||"",j=a[i+"size"]||1,k=e("edgeColor"),l=e("defaultNodeColor"),m=e("defaultEdgeColor"),n=e("edgeHoverLevel"),o=b[i+"x"],p=b[i+"y"],q=c[i+"x"],r=c[i+"y"],s=sigma.utils.getDistance(o,p,q,r);if(!h)switch(k){case"source":h=b.color||l;break;case"target":h=c.color||l;break;default:h=m}if(h="edge"===e("edgeHoverColor")?a.hover_color||h:a.hover_color||e("defaultEdgeHoverColor")||h,j*=e("edgeHoverSizeRatio"),f=sigma.utils.getCircleIntersection(o,p,j,q,r,s),g=sigma.utils.getCircleIntersection(q,r,j,o,p,s),d.save(),n)switch(d.shadowOffsetX=0,n){case 1:d.shadowOffsetY=1.5,d.shadowBlur=4,d.shadowColor="rgba(0,0,0,0.36)";break;case 2:d.shadowOffsetY=3,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.39)";break;case 3:d.shadowOffsetY=6,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.42)";break;case 4:d.shadowOffsetY=10,d.shadowBlur=20,d.shadowColor="rgba(0,0,0,0.47)";break;case 5:d.shadowOffsetY=15,d.shadowBlur=24,d.shadowColor="rgba(0,0,0,0.52)"}d.strokeStyle=h,d.lineWidth=j,d.beginPath(),d.moveTo(f.xi,f.yi),d.lineTo(g.xi_prime,g.yi_prime),d.closePath(),d.stroke(),d.beginPath(),d.moveTo(f.xi_prime,f.yi_prime),d.lineTo(g.xi,g.yi),d.closePath(),d.stroke(),n&&(d.shadowOffsetY=0,d.shadowBlur=0,d.shadowColor="#000000"),d.restore(),sigma.canvas.edges.labels&&(a.hover=!0,sigma.canvas.edges.labels.def(a,b,c,d,e),a.hover=!1)}}(),function(){"use strict";sigma.utils.pkg("sigma.canvas.edgehovers"),sigma.canvas.edgehovers.tapered=function(a,b,c,d,e){var f=a.active?a.active_color||e("defaultEdgeActiveColor"):a.color,g=e("prefix")||"",h=a[g+"size"]||1,i=e("edgeColor"),g=e("prefix")||"",j=e("defaultNodeColor"),k=e("defaultEdgeColor"),l=e("edgeHoverLevel"),m=b[g+"x"],n=b[g+"y"],o=c[g+"x"],p=c[g+"y"],q=sigma.utils.getDistance(m,n,o,p);if(!f)switch(i){case"source":f=b.color||j;break;case"target":f=c.color||j;break;default:f=k}f="edge"===e("edgeHoverColor")?a.hover_color||f:a.hover_color||e("defaultEdgeHoverColor")||f,h*=e("edgeHoverSizeRatio");var r=sigma.utils.getCircleIntersection(m,n,h,o,p,q);if(d.save(),l)switch(d.shadowOffsetX=0,l){case 1:d.shadowOffsetY=1.5,d.shadowBlur=4,d.shadowColor="rgba(0,0,0,0.36)";break;case 2:d.shadowOffsetY=3,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.39)";break;case 3:d.shadowOffsetY=6,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.42)";break;case 4:d.shadowOffsetY=10,d.shadowBlur=20,d.shadowColor="rgba(0,0,0,0.47)";break;case 5:d.shadowOffsetY=15,d.shadowBlur=24,d.shadowColor="rgba(0,0,0,0.52)"}d.globalAlpha=.65,d.fillStyle=f,d.beginPath(),d.moveTo(o,p),d.lineTo(r.xi,r.yi),d.lineTo(r.xi_prime,r.yi_prime),d.closePath(),d.fill(),l&&(d.shadowOffsetY=0,d.shadowBlur=0,d.shadowColor="#000000"),d.restore(),sigma.canvas.edges.labels&&(a.hover=!0,sigma.canvas.edges.labels.def(a,b,c,d,e),a.hover=!1)}}(),function(){"use strict";sigma.utils.pkg("sigma.canvas.edges"),sigma.canvas.edges.dashed=function(a,b,c,d,e){var f=a.active?a.active_color||e("defaultEdgeActiveColor"):a.color,g=e("prefix")||"",h=a[g+"size"]||1,i=e("edgeColor"),j=e("defaultNodeColor"),k=e("defaultEdgeColor"),l=a.active?e("edgeActiveLevel"):a.level;if(!f)switch(i){case"source":f=b.color||j;break;case"target":f=c.color||j;break;default:f=k}if(d.save(),l)switch(d.shadowOffsetX=0,l){case 1:d.shadowOffsetY=1.5,d.shadowBlur=4,d.shadowColor="rgba(0,0,0,0.36)";break;case 2:d.shadowOffsetY=3,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.39)";break;case 3:d.shadowOffsetY=6,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.42)";break;case 4:d.shadowOffsetY=10,d.shadowBlur=20,d.shadowColor="rgba(0,0,0,0.47)";break;case 5:d.shadowOffsetY=15,d.shadowBlur=24,d.shadowColor="rgba(0,0,0,0.52)"}a.active?d.strokeStyle="edge"===e("edgeActiveColor")?f||k:e("defaultEdgeActiveColor"):d.strokeStyle=f,d.setLineDash([8,3]),d.lineWidth=h,d.beginPath(),d.moveTo(b[g+"x"],b[g+"y"]),d.lineTo(c[g+"x"],c[g+"y"]),d.stroke(),l&&(d.shadowOffsetY=0,d.shadowBlur=0,d.shadowColor="#000000"),d.restore()}}(),function(){"use strict";sigma.utils.pkg("sigma.canvas.edges"),sigma.canvas.edges.dotted=function(a,b,c,d,e){var f=a.active?a.active_color||e("defaultEdgeActiveColor"):a.color,g=e("prefix")||"",h=a[g+"size"]||1,i=e("edgeColor"),j=e("defaultNodeColor"),k=e("defaultEdgeColor"),l=a.active?e("edgeActiveLevel"):a.level;if(!f)switch(i){case"source":f=b.color||j;break;case"target":f=c.color||j;break;default:f=k}if(d.save(),l)switch(d.shadowOffsetX=0,l){case 1:d.shadowOffsetY=1.5,d.shadowBlur=4,d.shadowColor="rgba(0,0,0,0.36)";break;case 2:d.shadowOffsetY=3,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.39)";break;case 3:d.shadowOffsetY=6,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.42)";break;case 4:d.shadowOffsetY=10,d.shadowBlur=20,d.shadowColor="rgba(0,0,0,0.47)";break;case 5:d.shadowOffsetY=15,d.shadowBlur=24,d.shadowColor="rgba(0,0,0,0.52)"}a.active?d.strokeStyle="edge"===e("edgeActiveColor")?f||k:e("defaultEdgeActiveColor"):d.strokeStyle=f,d.setLineDash([2]),d.lineWidth=h,d.beginPath(),d.moveTo(b[g+"x"],b[g+"y"]),d.lineTo(c[g+"x"],c[g+"y"]),d.stroke(),l&&(d.shadowOffsetY=0,d.shadowBlur=0,d.shadowColor="#000000"),d.restore()}}(),function(){"use strict";sigma.utils.pkg("sigma.canvas.edges"),sigma.canvas.edges.parallel=function(a,b,c,d,e){var f,g,h=a.active?a.active_color||e("defaultEdgeActiveColor"):a.color,i=e("prefix")||"",j=a[i+"size"]||1,k=e("edgeColor"),l=e("defaultNodeColor"),m=e("defaultEdgeColor"),n=a.active?e("edgeActiveLevel"):a.level,o=b[i+"x"],p=b[i+"y"],q=c[i+"x"],r=c[i+"y"],s=sigma.utils.getDistance(o,p,q,r);if(!h)switch(k){case"source":h=b.color||l;break;case"target":h=c.color||l;break;default:h=m}if(f=sigma.utils.getCircleIntersection(o,p,j,q,r,s),g=sigma.utils.getCircleIntersection(q,r,j,o,p,s),d.save(),n)switch(d.shadowOffsetX=0,n){case 1:d.shadowOffsetY=1.5,d.shadowBlur=4,d.shadowColor="rgba(0,0,0,0.36)";break;case 2:d.shadowOffsetY=3,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.39)";break;case 3:d.shadowOffsetY=6,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.42)";break;case 4:d.shadowOffsetY=10,d.shadowBlur=20,d.shadowColor="rgba(0,0,0,0.47)";break;case 5:d.shadowOffsetY=15,d.shadowBlur=24,d.shadowColor="rgba(0,0,0,0.52)"}a.active?d.strokeStyle="edge"===e("edgeActiveColor")?h||m:e("defaultEdgeActiveColor"):d.strokeStyle=h,d.lineWidth=j,d.beginPath(),d.moveTo(f.xi,f.yi),d.lineTo(g.xi_prime,g.yi_prime),d.closePath(),d.stroke(),d.beginPath(),d.moveTo(f.xi_prime,f.yi_prime),d.lineTo(g.xi,g.yi),d.closePath(),d.stroke(),n&&(d.shadowOffsetY=0,d.shadowBlur=0,d.shadowColor="#000000"),d.restore()}}(),function(){"use strict";sigma.utils.pkg("sigma.canvas.edges"),sigma.canvas.edges.tapered=function(a,b,c,d,e){var f=a.active?a.active_color||e("defaultEdgeActiveColor"):a.color,g=e("prefix")||"",h=a[g+"size"]||1,i=e("edgeColor"),g=e("prefix")||"",j=e("defaultNodeColor"),k=e("defaultEdgeColor"),l=a.active?e("edgeActiveLevel"):a.level,m=b[g+"x"],n=b[g+"y"],o=c[g+"x"],p=c[g+"y"],q=sigma.utils.getDistance(m,n,o,p);if(!f)switch(i){case"source":f=b.color||j;break;case"target":f=c.color||j;break;default:f=k}var r=sigma.utils.getCircleIntersection(m,n,h,o,p,q);if(d.save(),l)switch(d.shadowOffsetX=0,l){case 1:d.shadowOffsetY=1.5,d.shadowBlur=4,d.shadowColor="rgba(0,0,0,0.36)";break;case 2:d.shadowOffsetY=3,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.39)";break;case 3:d.shadowOffsetY=6,d.shadowBlur=12,d.shadowColor="rgba(0,0,0,0.42)";break;case 4:d.shadowOffsetY=10,d.shadowBlur=20,d.shadowColor="rgba(0,0,0,0.47)";break;case 5:d.shadowOffsetY=15,d.shadowBlur=24,d.shadowColor="rgba(0,0,0,0.52)"}a.active?d.fillStyle="edge"===e("edgeActiveColor")?f||k:e("defaultEdgeActiveColor"):d.fillStyle=f,d.globalAlpha=.65,d.beginPath(),d.moveTo(o,p),d.lineTo(r.xi,r.yi),d.lineTo(r.xi_prime,r.yi_prime),d.closePath(),d.fill(),l&&(d.shadowOffsetY=0,d.shadowBlur=0,d.shadowColor="#000000"),d.restore()}}();
//# sourceMappingURL=sigma.renderers.customEdgeShapes.min.js.map