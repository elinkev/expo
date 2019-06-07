package host.exp.exponent.notifications.postoffice;

import android.os.Bundle;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PostOfficeInterfaceProxy implements PostOfficeInterface {

  private Executor mSingleThreadExecutor = Executors.newSingleThreadExecutor();

  private static volatile PostOfficeInterfaceProxy instance = null;

  private PostOfficeInterface mPostOffice;

  private PostOfficeInterfaceProxy() {
    mPostOffice = new PostOffice();
  }

  public static synchronized PostOfficeInterface getInstance() {
    if (instance == null) {
      instance = new PostOfficeInterfaceProxy();
    }
    return instance;
  }

  @Override
  public void notifyAboutUserInteraction(final String experienceId, final Bundle userInteraction) {
    mSingleThreadExecutor.execute(()->mPostOffice.notifyAboutUserInteraction(experienceId, userInteraction));
  }

  @Override
  public void sendForegroundNotification(final String experienceId, final Bundle notification) {
    mSingleThreadExecutor.execute(()->mPostOffice.sendForegroundNotification(experienceId, notification));
  }

  @Override
  public void registerModuleAndGetPendingDeliveries(final String experienceId, final MailboxInterface mailbox) {
    mSingleThreadExecutor.execute(()->mPostOffice.registerModuleAndGetPendingDeliveries(experienceId, mailbox));
  }

  @Override
  public void unregisterModule(final String experienceId) {
    mSingleThreadExecutor.execute(()->mPostOffice.unregisterModule(experienceId));
  }
}
