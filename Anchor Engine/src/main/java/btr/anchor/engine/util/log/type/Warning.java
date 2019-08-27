package btr.anchor.engine.util.log.type;
/*  *
 * Urheberrechtshinweis
 * Erstellt am 28.05.2019 um 18:28
 * Alle Inhalte dieses Quelltextes sind Urheberechtlich geschützt.
 * Das Urheberrecht liegt, soweit nicht ausdrücklich anders gekennzeichnet, bei Sören Wicke
 * Alle Rechte vorbehalten.
 * Jede Art der Vervielfältigung, Verbreitung, Verleihung, des öffentlich Zugänglich macheng oder anderer Nutzung bedarf der ausdrücklichen, schriftlichen Zustimmung von Sören Wicke.
 *   */
public class Warning implements Log {
    @Override
    public void send(String log) {
        System.out.println("[WARNING] " + log);
    }
}
