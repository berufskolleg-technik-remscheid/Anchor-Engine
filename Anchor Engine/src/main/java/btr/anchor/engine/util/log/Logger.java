package btr.anchor.engine.util.log;

import btr.anchor.engine.util.log.type.Debug;
import btr.anchor.engine.util.log.type.Info;
import btr.anchor.engine.util.log.type.Warning;
import btr.anchor.engine.util.log.type.Error;

public class Logger {

    public static Debug debug = new Debug();
    public static Info info = new Info();
    public static Warning warning = new Warning();
    public static Error error = new Error();
}