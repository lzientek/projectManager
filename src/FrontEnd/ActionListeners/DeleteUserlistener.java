package FrontEnd.ActionListeners;

import BackEnd.User;
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

    public DeleteUserlistener(User user, List<User> userList) {
        this.user = user;
        this.userList = userList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FormulaireProject form = (FormulaireProject) e.getSource();
        form.loadUsers();
        userList.remove(user);
    }
}
