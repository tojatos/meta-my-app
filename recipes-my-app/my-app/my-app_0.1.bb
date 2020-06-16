DESCRIPTION = "Simple Python application"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/tojatos/my_python_app.git \
           file://my-app.service \
    "
SRCREV = "89eca79ccb6abb0d365b8a97aa00d443e1ba187b"

S = "${WORKDIR}/git"

inherit systemd

SYSTEMD_SERVICE_${PN} = "my-app.service"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 my_python_app ${D}${bindir}

    install -d ${D}${systemd_unitdir}/system
    install -c -m 0644 ${WORKDIR}/my-app.service ${D}${systemd_unitdir}/system
}
