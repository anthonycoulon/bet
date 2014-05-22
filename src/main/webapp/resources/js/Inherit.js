function Inherit(destination, source) {
    for (var element in source) { 
        destination[element] = source[element];
    } 
}; 