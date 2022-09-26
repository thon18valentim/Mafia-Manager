package br.com.up.mafia.repositories;

import java.util.ArrayList;
import br.com.up.mafia.models.Action;
import br.com.up.mafia.models.ActionCategory;
import br.com.up.mafia.models.ActionSubCategory;
import br.com.up.mafia.models.Mafia;

public class Game {

    public static Game game;

    public static Game createGame(String name){
        if(game == null){
            game = new Game();
            mafia = new Mafia(name);
            actions = game.createActions();
            actionsChosen = new ArrayList<>();
        }
        return game;
    }

    private static Mafia mafia;
    private static ArrayList<Action> actions;
    public static int actionCount = 0;

    private ArrayList<Action> createActions(){
        // Creating actions
        ArrayList<Action> actions = new ArrayList<Action>(){
            {
                // Business actions (cash)
                add(new Action(1, "Ameaçar Comerciante", "vazio", ActionCategory.Cash, ActionSubCategory.Business));
                add(new Action(2, "Executar incêndio no Local", "vazio", ActionCategory.Cash, ActionSubCategory.Business));
                add(new Action(3, "Executar atentado no local", "vazio", ActionCategory.Cash, ActionSubCategory.Business));
                add(new Action(4, "Oferecer empréstimo", "vazio", ActionCategory.Cash, ActionSubCategory.Business));
                // Factories actions (cash)
                add(new Action(5, "Ameaçar Proprietário", "vazio", ActionCategory.Cash, ActionSubCategory.Factories));
                add(new Action(6, "Executar incêndio parcial no local", "vazio", ActionCategory.Cash, ActionSubCategory.Factories));
                add(new Action(7, "Executar atentado no local", "vazio", ActionCategory.Cash, ActionSubCategory.Factories));
                add(new Action(8, "Oferecer empréstimo", "vazio", ActionCategory.Cash, ActionSubCategory.Factories));
                // Police actions (Influence)
                add(new Action(9, "Subornar Guardas", "vazio", ActionCategory.Influence, ActionSubCategory.PoliceDeal));
                add(new Action(10, "Subornar Oficiais", "vazio", ActionCategory.Influence, ActionSubCategory.PoliceDeal));
                add(new Action(11, "Executar Atentado", "vazio", ActionCategory.Influence, ActionSubCategory.PoliceDeal));
                add(new Action(12, "Comprar político", "vazio", ActionCategory.Influence, ActionSubCategory.PoliceDeal));
                // Criminal groups actions (Influence)
                add(new Action(13, "Executar atentado contra gangue rival", "vazio", ActionCategory.Influence, ActionSubCategory.CriminalGroupsDeal));
                add(new Action(14, "Executar  atentado contra liderança criminosa", "vazio", ActionCategory.Influence, ActionSubCategory.CriminalGroupsDeal));
                add(new Action(15, "Contratar Assassinos", "vazio", ActionCategory.Influence, ActionSubCategory.CriminalGroupsDeal));
                add(new Action(16, "Ameaçar Fornecedores", "vazio", ActionCategory.Influence, ActionSubCategory.CriminalGroupsDeal));
                // Regional Business coordination actions (Influence)
                add(new Action(17, "Executar atentado contra concorrentes", "vazio", ActionCategory.Influence, ActionSubCategory.BusinessCoordination));
                add(new Action(18, "Ameaçar clientes de concorrentes", "vazio", ActionCategory.Influence, ActionSubCategory.BusinessCoordination));
                add(new Action(19, "Oferecer acordo", "vazio", ActionCategory.Influence, ActionSubCategory.BusinessCoordination));
                add(new Action(20, "Destruir concorrentes", "vazio", ActionCategory.Influence, ActionSubCategory.BusinessCoordination));
                // Guns actions (Strength)
                add(new Action(21, "Roubar armamento do exército", "vazio", ActionCategory.Strength, ActionSubCategory.Guns));
                add(new Action(22, "Roubar armamento da polícia", "vazio", ActionCategory.Strength, ActionSubCategory.Guns));
                add(new Action(23, "Contratar fornecedor de armas", "vazio", ActionCategory.Strength, ActionSubCategory.Guns));
                add(new Action(24, "Contratar fornecedor militar de armas", "vazio", ActionCategory.Strength, ActionSubCategory.Guns));
                // Henchman actions (Strength)
                add(new Action(25, "Contratar capangas", "vazio", ActionCategory.Strength, ActionSubCategory.Henchman));
                add(new Action(26, "Propaganda de benefícios da família mafiosa", "vazio", ActionCategory.Strength, ActionSubCategory.Henchman));
                add(new Action(27, "Oferecer pequenos trabalhos", "vazio", ActionCategory.Strength, ActionSubCategory.Henchman));
                add(new Action(28, "Executar favores", "vazio", ActionCategory.Strength, ActionSubCategory.Henchman));
                add(new Action(29, "Fazer acordo com a milícia", "vazio", ActionCategory.Strength, ActionSubCategory.Henchman));
            }
        };

        // Setting Attributes into actions
        // Business actions (cash)
        actions.get(0).SetAttributes(1, 2, 3, 0, 0, 0);
        actions.get(1).SetAttributes(3, 3, 2, 0, 0, 0);
        actions.get(2).SetAttributes(3, 3, 3, 0, 0, 0);
        actions.get(3).SetAttributes(-1, 1, 1, 0, 0, 0);
        // Factory actions (cash)
        actions.get(4).SetAttributes(1, 1, 1, 0, 0, 0);
        actions.get(5).SetAttributes(3, 3, 1, 0, 0, 0);
        actions.get(6).SetAttributes(3, 3, 2, 0, 0, 0);
        actions.get(7).SetAttributes(-1, 1, 3, 0, 0, 0);
        // Police actions (Influence)
        actions.get(8).SetAttributes(-1, -1, -1, -1, 0, 0);
        actions.get(9).SetAttributes(-2, 1, 2, -2, 0, 0);
        actions.get(10).SetAttributes(3, 3, 2, 0, -3, 0);
        actions.get(11).SetAttributes(-3, 3, 3, -3, 0, 0);
        // Criminal groups actions (Influence)
        actions.get(12).SetAttributes(3, 1, 3, 0, -2, 0);
        actions.get(13).SetAttributes(1, 3, 3, 0, -2, 0);
        actions.get(14).SetAttributes(1, 3, 1, -2, 0, 3);
        actions.get(15).SetAttributes(2, 1, 2, 0, 0, 0);
        // Regional Business coordination actions (Influence)
        actions.get(16).SetAttributes(2, 3, 3, 0, -1, 0);
        actions.get(17).SetAttributes(1, 1, 1, 0, 0, 0);
        actions.get(18).SetAttributes(-1, -3, -3, 0, 0, 0);
        actions.get(19).SetAttributes(3, 3, 1, 0, 0, 0);
        // Guns actions (Strength)
        actions.get(20).SetAttributes(3, 3, 3, 0, 3, 0);
        actions.get(21).SetAttributes(3, 2, 2, 0, 2, 0);
        actions.get(22).SetAttributes(1, 1, 1, -2, 2, 0);
        actions.get(23).SetAttributes(3, 3, 2, -3, 3, 0);
        // Henchman actions (Strength)
        actions.get(24).SetAttributes(1, 1, 1, -3, 0, 2);
        actions.get(25).SetAttributes(1, -2, -2, -1, 0, 1);
        actions.get(26).SetAttributes(1, -1, -1, -2, 0, 1);
        actions.get(27).SetAttributes(2, -1, -1, 1, 0, 1);
        actions.get(28).SetAttributes(3, 1, -1, 3, 0, 3);

        return actions;
    }

    public static Mafia getMafia(){
        return mafia;
    }

    public static ArrayList<Action> getActions(){
        return actions;
    }

    public static ArrayList<Integer> actionsChosen;
}
