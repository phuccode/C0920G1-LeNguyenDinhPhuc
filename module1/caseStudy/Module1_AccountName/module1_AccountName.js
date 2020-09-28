
function importA() {
     document.getElementById('name2').innerHTML =  document.getElementById('name').value;
     document.getElementById('idCode2').innerHTML =  document.getElementById('idCode').value;
     document.getElementById('birthday2').innerHTML =  document.getElementById('birthday').value;
     document.getElementById('email2').innerHTML =  document.getElementById('email').value;
     document.getElementById('customer2').innerHTML =  document.getElementById('customer').value;
     document.getElementById('discount2').innerHTML =  document.getElementById('discount').value;
     document.getElementById('amount2').innerHTML =  document.getElementById('amount').value;
     document.getElementById('rentDays2').innerHTML =  document.getElementById('rentDays').value;
     document.getElementById('suv2').innerHTML =  document.getElementById('suv').value;
     document.getElementById('classify2').innerHTML =  document.getElementById('classify').value;
     let villa = document.getElementById('villa');
     let house = document.getElementById('house');
     let room = document.getElementById('room');
     let chiPhi ;
     switch (villa) {
         case villa :
             chiPhi = document.getElementById('rentDays').value * 500 * (1 - document.getElementById('discount').value / 100);
             break;
         case house :
             chiPhi = document.getElementById('rentDays').value * 300 * (1 - document.getElementById('discount').value / 100);
            break;
         case room :
             chiPhi = document.getElementById('rentDays').value * 100 * (1 - document.getElementById('discount').value / 100);
            break;
     }  document.getElementById('cacl').innerHTML = chiPhi;
}