# <h4>micro-service Level 1 - <h6>"Communication and Discovery-Server"</h6></h4>
# <h4>Step 1 - Discovery-Server</h4>
  1.<ui>"Maven Clean"</ui>
  2.<ui>"Maven install"</ui>
  3.<ui>"Run As Spring Boot App"</ui>
  <h4>Step 2 - Movie Catalog Service</h4>
  1.<ui>"Maven Clean"</ui>
  2.<ui>"Maven install"</ui>
  3.<ui>"Run As Spring Boot App"</ui>
 <h4>Step 3 - Movie Info Service</h4>
  1.<ui>"Maven Clean"</ui>
  2.<ui>"Maven install"</ui>
  3.<ui>"Run As Spring Boot App"</ui>
  <h4>Step 4 - Movie Rating Service</h4>
  1.<ui>"Maven Clean"</ui>
  2.<ui>"Maven install"</ui>
  3.<ui>"Run As Spring Boot App"</ui>
  
  <p> After Running all Spring Boot Application. you can open your browser and type "http://localhost:8761/". You can see all running services over that server. after that just confermation for you application is calling on catelog or not call "http://localhost:8081/catalog/foo". before calling this url make sure you are running all service. </p>


