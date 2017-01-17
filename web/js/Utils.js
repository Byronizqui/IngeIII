function validateEnter(e) {
    var key = e.keyCode || e.which;
    if (key == 13) {
        return true;
    } else {
        return false;
    }
}
function clearRoot(root) {
    while (root.firstChild)
        root.removeChild(root.firstChild);
}
                                        