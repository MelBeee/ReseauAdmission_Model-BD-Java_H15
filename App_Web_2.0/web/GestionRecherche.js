function GestionCheckBox(className){
 var checkBoxArray =  document.getElementsByClassName("chk_group");

 var checkedValues = '?';

 alert('List length: ' + checkBoxArray.length);
var nb = 0;
 for (var i=0; i<checkBoxArray.length; i++) 
 { 
  var checkBoxRef = checkBoxArray[i];
   
  if ( checkBoxRef.checked == true ) 
  {
    if ( checkedValues.length > 0 ){  
     checkedValues += 'cat'+nb +'=';
     checkedValues += checkBoxRef.value + '&';
     nb++;
   }
  }
}
checkedValues = checkedValues.slice(0,checkedValues.length - 1);
 alert('Items checked: ' + checkedValues);

  window.location.href = 'http://localhost:8084/App_Web_2.0/Acceuil' + checkedValues;
}

function GestionRechercheArtiste(){
var boxValue = document.getElementById("Rartiste");
 alert(boxValue.value);
window.location.href = 'http://localhost:8084/App_Web_2.0/Acceuil?Artiste=' + boxValue.value;

}

function Gestion(){
  var  combo = document.getElementById("combo");
    window.location.href = 'http://localhost:8084/App_Web_2.0/Acceuil?Salle=' + combo[combo.selectedIndex].text;
}

function GestionSetting(){
   var length = arguments.length;  
   alert(length);
    alert(arguments[0]+" "+arguments[1]);
    if(arguments[0]==="categorie"){      
       var checkBoxArray =  document.getElementsByClassName("chk_group");
       
       for (var i=0; i< checkBoxArray.length; i++){            
             for (var j=0; j < length; j++){                
              if( checkBoxArray[i].value === arguments[j]){              
                  checkBoxArray[i].checked = true;
              }                 
          }
       }
    }
    else if(arguments[0]==="Artiste"){       
        var boxValue = document.getElementById("Rartiste");
        boxValue.value = arguments[1];
    }
    else{
        var  combo = document.getElementById("combo");
        	for(var i=0; i<=combo.length; i++){
                 if (combo[i].text === arguments[1]){
                     combo.selectedIndex = i;
                 }                    
         }   
    }
       
}