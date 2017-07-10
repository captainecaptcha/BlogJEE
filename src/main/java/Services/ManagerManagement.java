package Services;

import DAO.ManagerAccess;

public class ManagerManagement {

    private ManagerAccess managerAccess;

    public <T> T Add(T obj)
    {
        return managerAccess.Add(obj);
    }

    public <T>boolean Delete(T obj)
    {
        return managerAccess.Delete(obj);
    }

    public <T>boolean Update(T obj)
    {
        return managerAccess.Update(obj);
    }
}
