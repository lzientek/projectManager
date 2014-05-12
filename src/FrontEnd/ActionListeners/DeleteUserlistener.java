package FrontEnd.ActionListeners;

import BackEnd.User;
import FrontEnd.Controls.FormulaireAvecDesUsers;
import FrontEnd.Controls.FormulaireProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by lucas on 09/05/2014.
 */
public class DeleteUserlistener implements ActionListener {
    private User user;
    private List<User> userList;
    private FormulaireAvecDesUsers form;

    public DeleteUserlistener(User user, List<User> userList, FormulaireAvecDesUsers form) {
        this.user = user;
        this.userList = userList;
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userList.remove(user);
        form.loadUsers();
    }
}
