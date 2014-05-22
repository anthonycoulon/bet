function bind(objet, methode) {
    return function() { 
        return methode.apply(objet, arguments);
    }; 
};