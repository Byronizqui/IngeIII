
  function Contenedor() {
    this.Contenedor();
  };
  
  Contenedor.prototype={
  	items: [],
	Contenedor: function(){
	  this.items=new Array();
	},
	add: function(producto){
	  this.items.push(producto);
	},
	remove: function(idx){
	  this.items.splice(idx, 1);
	  //this.items.pop(producto);
	},
	get: function(i){
	  return this.items[i];
	},
	last: function(){
	  return this.items[this.items.length - 1];
	},
	size:function(){
	  return this.items.length;
	}
  };
  
  Contenedor.from= function(plain){
    car = new Contenedor();
	car.items=plain.items;
	return car;
  }
  
    Contenedor.to= function(car){
    return {
        _class : 'Contenedor',
        items : car.items
    };
  }
