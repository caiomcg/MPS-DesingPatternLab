package infra;

import java.io.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import model.User;

public class Database implements Persistence {

	private static final Logger LOGGER = Logger.getLogger(Database.class.getName());

	private String dbFile;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private HashMap<String, User> data;

	public Database() throws IOException {
		this.dbFile = createDatabaseFile();
		this.inputStream = null;
		this.outputStream = null;
		this.data = new HashMap<String, User>();
	}

	public Database(String dbFile) {
		this.dbFile = dbFile;
		this.inputStream = null;
		this.outputStream = null;
	}

	@Override
	public void saveOnDatabase(Map<String, User> data) throws PersistenceException {
		LOGGER.info("Saving user in the database.");
		try {
			openDatabase();
			outputStream.writeObject(data);
		}
		catch (IOException ex) {
			LOGGER.severe("Error when saving user in the database.");
			LOGGER.severe(ex.getMessage());
			throw new PersistenceException("Can't save user on database. Contact support.");
		}
		finally {
			try {
				closeDatabase();
			}
			catch(IOException ex) {
				LOGGER.warning("Database was not closed properly.");
			}
		}
		LOGGER.info("User saved successfully.");
	}

	@Override
	@SuppressWarnings("unchecked")
	public HashMap<String, User> loadFromDatabase() {
		LOGGER.info("Loading users from database.");
		try {
			openDatabase();
			data = (HashMap<String, User>) inputStream.readObject();
		} catch (EOFException exc) {
            ;
        }catch (ClassNotFoundException | IOException ex) {
			LOGGER.severe("Error when load users from database.");
			LOGGER.severe(ex.getMessage());
//			throw new PersistenceException("Can't load users from database. Contact support.");
		}
		finally {
			try {
				closeDatabase();
			}
			catch(IOException ex) {
				LOGGER.warning("Database was not closed properly.");
			}
		}
		LOGGER.info("Users successfully loaded.");
		return data;
	}

	private String createDatabaseFile() throws IOException {
		String filePath = System.getProperty("user.dir") + "/db.bin";
		System.out.println(filePath);
		File file = new File(filePath);
		file.getParentFile().mkdirs();
		file.createNewFile();
		return filePath;
	}

	private void openDatabase() throws IOException {
		LOGGER.info("Opening Database.");
		try {
			inputStream = new ObjectInputStream(new FileInputStream(dbFile));
			outputStream = new ObjectOutputStream(new FileOutputStream(dbFile));
		}
		catch (IOException ex) {
			LOGGER.severe("Can't open database file.");
			throw ex;
		}
	}

	private void closeDatabase() throws IOException {
		LOGGER.info("Closing database.");
		try {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
		catch (IOException ex) {
			LOGGER.severe("Can't close database file.");
			throw ex;
		}
	}
}
