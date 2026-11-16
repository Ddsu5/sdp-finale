package source;
import java.util.ArrayList;
import java.util.List;

public class OnlineStorage {
    private List<String> data = new ArrayList<>();
    public OnlineStorage() {
        data.add("21;Don't Stop Me Now;Queen;rock;209");
        data.add("22;Under Pressure;Queen;rock;248");
        data.add("23;Somebody to Love;Queen;rock;296");
        data.add("24;We Will Rock You;Queen;rock;122");
        data.add("25;Let It Be;The Beatles;pop;243");
        data.add("26;Come Together;The Beatles;rock;259");
        data.add("27;Beat It;Michael Jackson;pop;258");
        data.add("28;Bad;Michael Jackson;pop;247");
        data.add("29;Back in Black;AC/DC;rock;255");
        data.add("30;Highway to Hell;AC/DC;rock;208");
        data.add("31;Someone Like You;Adele;pop;285");
        data.add("32;Skyfall;Adele;pop;286");
        data.add("33;Castle on the Hill;Ed Sheeran;pop;261");
        data.add("34;Thinking Out Loud;Ed Sheeran;pop;281");
        data.add("35;Mockingbird;Eminem;rap;250");
        data.add("36;Not Afraid;Eminem;rap;248");
        data.add("37;Faint;Linkin Park;rock;162");
        data.add("38;Enter Sandman;Metallica;rock;331");
        data.add("39;Nothing Else Matters;Metallica;rock;388");
        data.add("40;Wonderwall;Oasis;rock;258");
        data.add("41;Blinding Lights;The Weeknd;pop;200");
        data.add("42;Starboy;The Weeknd;pop;230");
        data.add("43;Shallow;Lady Gaga;pop;215");
        data.add("44;Bad Guy;Billie Eilish;pop;194");
        data.add("45;Ocean Eyes;Billie Eilish;pop;200");
        data.add("46;Группа крови;Kino;rock;286");
        data.add("47;Звезда по имени Солнце;Kino;rock;225");
        data.add("48;Выхода нет;Сплин;rock;240");
        data.add("49;Комбат;Любэ;rock;250");
        data.add("50;Батарейка;Жуки;rock;200");
        data.add("51;Полковнику никто не пишет;Би-2;rock;310");
        data.add("52;Қайран елім;Dimash Kudaibergen;pop;255");
        data.add("53;Daybreak;Dimash Kudaibergen;pop;225");
        data.add("54;Алаша;Ninety One;pop;210");
        data.add("55;Адай;Dimash Kudaibergen;pop;240");
        data.add("56;Mooz;Ninety One;pop;225");
        data.add("57;Bari Biled;Ninety One;pop;237");
    }

    public List<String> fetchAll() {
        return data;
    }
}
