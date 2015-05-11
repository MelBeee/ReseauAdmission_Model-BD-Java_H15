function GestionCheckBox(){

function iterateCheckBoxList(className) 
{
 var elementRef =  document.getElementsByClassName(className);
 var checkBoxArray = elementRef.getElementsByTagName('input');
 var checkedValues = ' ?';

 //alert('List length: ' + checkBoxArray.length);

 for (var i=0; i<checkBoxArray.length; i++) 
 { 
  var checkBoxRef = checkBoxArray[i];

  if ( checkBoxRef.checked == true ) 
  {
  
  // if ( labelArray.length > 0 )
  // {
    if ( checkedValues.length > 0 )
     checkedValues += 'cat'+i +' ';

    checkedValues += labelArray[0].innerHTML + ' & ';
   }
  }
 //}

 //alert('Items checked: ' + checkedValues);

  window.location.href = 'http://localhost:8084/App_Web_2.0/Acceuil' + checkedValues;
}



}