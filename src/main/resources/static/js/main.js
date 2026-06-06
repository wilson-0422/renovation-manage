document.addEventListener('DOMContentLoaded', function() {
    var deleteButtons = document.querySelectorAll('.btn-danger');
    deleteButtons.forEach(function(btn) {
        if (!btn.getAttribute('onclick')) {
            btn.addEventListener('click', function(e) {
                if (!confirm('确认删除此记录？')) {
                    e.preventDefault();
                }
            });
        }
    });

    var currentPath = window.location.pathname;
    var navLinks = document.querySelectorAll('.nav-link');
    navLinks.forEach(function(link) {
        if (link.getAttribute('href') && currentPath.startsWith(link.getAttribute('href')) && link.getAttribute('href') !== '/') {
            link.classList.add('active');
        }
    });
});
