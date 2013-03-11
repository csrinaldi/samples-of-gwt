package org.jboss.errai.ioc.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.KeyEvent;
import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.IsRenderable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.samples.errai.client.local.App;
import com.logikas.samples.errai.client.presenter.LoginActivity;
import com.logikas.samples.errai.client.presenter.configure.CenterActivityManagerProvider;
import com.logikas.samples.errai.client.presenter.configure.CenterActivityMapper;
import com.logikas.samples.errai.client.presenter.configure.MVPInitializer;
import com.logikas.samples.errai.client.view.LoginUserView;
import com.logikas.samples.errai.client.view.LoginUserView.Presenter;
import com.logikas.samples.errai.client.view.impl.LoginUserWidget;
import com.logikas.samples.errai.client.view.layout.HomePage;
import com.logikas.samples.errai.client.view.layout.PageLayout;
import com.logikas.samples.errai.client.view.layout.impl.HomePageImpl;
import com.logikas.samples.errai.client.view.layout.impl.MainLayoutImpl;
import com.logikas.samples.errai.client.view.layout.impl.PageLayoutImpl;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Provider;
import org.jboss.errai.bus.client.framework.Subscription;
import org.jboss.errai.databinding.client.DataBinderProvider;
import org.jboss.errai.databinding.client.DataBindingModuleBootstrapper;
import org.jboss.errai.enterprise.client.cdi.AbstractCDIEventCallback;
import org.jboss.errai.enterprise.client.cdi.CDIEventTypeLookup;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.enterprise.client.cdi.InstanceProvider;
import org.jboss.errai.enterprise.client.cdi.api.CDI;
import org.jboss.errai.enterprise.client.jaxrs.JaxrsModuleBootstrapper;
import org.jboss.errai.ioc.client.api.ContextualTypeProvider;
import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ioc.client.api.builtin.CallerProvider;
import org.jboss.errai.ioc.client.api.builtin.DisposerProvider;
import org.jboss.errai.ioc.client.api.builtin.IOCBeanManagerProvider;
import org.jboss.errai.ioc.client.api.builtin.InitBallotProvider;
import org.jboss.errai.ioc.client.api.builtin.MessageBusProvider;
import org.jboss.errai.ioc.client.api.builtin.RequestDispatcherProvider;
import org.jboss.errai.ioc.client.api.builtin.RootPanelProvider;
import org.jboss.errai.ioc.client.api.builtin.SenderProvider;
import org.jboss.errai.ioc.client.container.CreationalCallback;
import org.jboss.errai.ioc.client.container.CreationalContext;
import org.jboss.errai.ioc.client.container.DestructionCallback;
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.jboss.errai.ioc.client.container.InitializationCallback;
import org.jboss.errai.ui.client.widget.ListWidgetProvider;
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;

public class BootstrapperImpl implements Bootstrapper {
  {
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyPressEvent", "com.google.gwt.event.dom.client.KeyEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyPressEvent", "com.google.gwt.event.dom.client.DomEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyPressEvent", "com.google.gwt.event.dom.client.HasNativeEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyPressEvent", "com.google.gwt.event.shared.GwtEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyPressEvent", "com.google.web.bindery.event.shared.Event");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyPressEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyCodeEvent", "com.google.gwt.event.dom.client.KeyEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyCodeEvent", "com.google.gwt.event.dom.client.DomEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyCodeEvent", "com.google.gwt.event.dom.client.HasNativeEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyCodeEvent", "com.google.gwt.event.shared.GwtEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyCodeEvent", "com.google.web.bindery.event.shared.Event");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyCodeEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyUpEvent", "com.google.gwt.event.dom.client.KeyCodeEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyUpEvent", "com.google.gwt.event.dom.client.KeyEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyUpEvent", "com.google.gwt.event.dom.client.DomEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyUpEvent", "com.google.gwt.event.dom.client.HasNativeEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyUpEvent", "com.google.gwt.event.shared.GwtEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyUpEvent", "com.google.web.bindery.event.shared.Event");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyUpEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyEvent", "com.google.gwt.event.dom.client.DomEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyEvent", "com.google.gwt.event.dom.client.HasNativeEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyEvent", "com.google.gwt.event.shared.GwtEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyEvent", "com.google.web.bindery.event.shared.Event");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyEvent", "java.lang.Object");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyDownEvent", "com.google.gwt.event.dom.client.KeyCodeEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyDownEvent", "com.google.gwt.event.dom.client.KeyEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyDownEvent", "com.google.gwt.event.dom.client.DomEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyDownEvent", "com.google.gwt.event.dom.client.HasNativeEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyDownEvent", "com.google.gwt.event.shared.GwtEvent");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyDownEvent", "com.google.web.bindery.event.shared.Event");
    CDIEventTypeLookup.get().addLookup("com.google.gwt.event.dom.client.KeyDownEvent", "java.lang.Object");
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
    new JaxrsModuleBootstrapper().run();
  }
  private final Any _1998831462Any_95716 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Default _1998831462Default_26508945 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_30012296 = new Annotation[] { _1998831462Any_95716, _1998831462Default_26508945 };
  private final LoadAsync _1369430986LoadAsync_0 = new LoadAsync() {
    public Class annotationType() {
      return LoadAsync.class;
    }
    public String toString() {
      return "@org.jboss.errai.ioc.client.api.LoadAsync()";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_11096404 = new Annotation[] { _1369430986LoadAsync_0, _1998831462Any_95716 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<CenterActivityManagerProvider> inj4110_CenterActivityManagerProvider_creational = new CreationalCallback<CenterActivityManagerProvider>() {
    public CenterActivityManagerProvider getInstance(final CreationalContext context) {
      final CenterActivityManagerProvider inj4109_CenterActivityManagerProvider = new CenterActivityManagerProvider();
      context.addBean(context.getBeanReference(CenterActivityManagerProvider.class, arrayOf_19635043Annotation_30012296), inj4109_CenterActivityManagerProvider);
      return inj4109_CenterActivityManagerProvider;
    }
  };
  private final CenterActivityManagerProvider inj4109_CenterActivityManagerProvider = inj4110_CenterActivityManagerProvider_creational.getInstance(context);
  private final CreationalCallback<DataBinderProvider> inj4111_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj4095_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_30012296), inj4095_DataBinderProvider);
      return inj4095_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj4095_DataBinderProvider = inj4111_DataBinderProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj4112_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj4089_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_30012296), inj4089_RequestDispatcherProvider);
      return inj4089_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj4089_RequestDispatcherProvider = inj4112_RequestDispatcherProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj4113_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj4097_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_30012296), inj4097_InstanceProvider);
      return inj4097_InstanceProvider;
    }
  };
  private final InstanceProvider inj4097_InstanceProvider = inj4113_InstanceProvider_creational.getInstance(context);
  private final CreationalCallback<RootPanelProvider> inj4114_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj4091_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_30012296), inj4091_RootPanelProvider);
      return inj4091_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj4091_RootPanelProvider = inj4114_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj4115_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj4093_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_30012296), inj4093_IOCBeanManagerProvider);
      return inj4093_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj4093_IOCBeanManagerProvider = inj4115_IOCBeanManagerProvider_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj4116_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj4087_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_30012296), inj4087_MessageBusProvider);
      return inj4087_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj4087_MessageBusProvider = inj4116_MessageBusProvider_creational.getInstance(context);
  private InitializationCallback<App> init_inj4117_App = new InitializationCallback<App>() {
    public void init(final App obj) {
      obj.init();
    }
  };
  private final CreationalCallback<App> inj4118_App_creational = new CreationalCallback<App>() {
    public App getInstance(final CreationalContext context) {
      final App inj4117_App = new App();
      context.addBean(context.getBeanReference(App.class, arrayOf_19635043Annotation_30012296), inj4117_App);
      _$295373500_eventBus(inj4117_App, inj4097_InstanceProvider.provide(new Class[] { EventBus.class }, null));
      final Subscription var17 = CDI.subscribeLocal("com.google.gwt.event.dom.client.KeyEvent", new AbstractCDIEventCallback<KeyEvent>() {
        public void fireEvent(final KeyEvent event) {
          inj4117_App.keyEventManager(event);
        }
        public String toString() {
          return "Observer: com.google.gwt.event.dom.client.KeyEvent []";
        }
      });
      context.addDestructionCallback(inj4117_App, new DestructionCallback<App>() {
        public void destroy(final App obj) {
          var17.remove();
        }
      });
      context.addInitializationCallback(inj4117_App, init_inj4117_App);
      return inj4117_App;
    }
  };
  private final App inj4117_App = inj4118_App_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj4119_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj4101_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_30012296), inj4101_EventProvider);
      return inj4101_EventProvider;
    }
  };
  private final EventProvider inj4101_EventProvider = inj4119_EventProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj4120_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj4107_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_30012296), inj4107_SenderProvider);
      return inj4107_SenderProvider;
    }
  };
  private final SenderProvider inj4107_SenderProvider = inj4120_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj4121_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj4099_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_30012296), inj4099_InitBallotProvider);
      return inj4099_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj4099_InitBallotProvider = inj4121_InitBallotProvider_creational.getInstance(context);
  private InitializationCallback<PageLayoutImpl> init_inj4123_PageLayoutImpl = new InitializationCallback<PageLayoutImpl>() {
    public void init(final PageLayoutImpl obj) {
      obj.init();
    }
  };
  private final CreationalCallback<PageLayoutImpl> inj4124_PageLayoutImpl_creational = new CreationalCallback<PageLayoutImpl>() {
    public PageLayoutImpl getInstance(final CreationalContext context) {
      final PageLayoutImpl inj4123_PageLayoutImpl = new PageLayoutImpl();
      context.addBean(context.getBeanReference(PageLayoutImpl.class, arrayOf_19635043Annotation_30012296), inj4123_PageLayoutImpl);
      context.addInitializationCallback(inj4123_PageLayoutImpl, new InitializationCallback<PageLayoutImpl>() {
        public void init(PageLayoutImpl obj) {
          com_logikas_samples_errai_client_view_layout_impl_PageLayoutImplTemplateResource var18 = GWT.create(com_logikas_samples_errai_client_view_layout_impl_PageLayoutImplTemplateResource.class);
          Element var19 = TemplateUtil.getRootTemplateElement(var18.getContents().getText(), "");
          Map<String, Element> var20 = TemplateUtil.getDataFieldElements(var19);
          Map<String, Widget> var21 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj4123_PageLayoutImpl, var19, var21.values());
        }
      });
      context.addInitializationCallback(inj4123_PageLayoutImpl, init_inj4123_PageLayoutImpl);
      return inj4123_PageLayoutImpl;
    }
  };
  private InitializationCallback<HomePageImpl> init_inj2875_HomePageImpl = new InitializationCallback<HomePageImpl>() {
    public void init(final HomePageImpl obj) {
      obj.init();
    }
  };
  private final CreationalCallback<HomePageImpl> inj4125_HomePageImpl_creational = new CreationalCallback<HomePageImpl>() {
    public HomePageImpl getInstance(final CreationalContext context) {
      final HomePageImpl inj2875_HomePageImpl = new HomePageImpl();
      context.addBean(context.getBeanReference(HomePageImpl.class, arrayOf_19635043Annotation_30012296), inj2875_HomePageImpl);
      context.addInitializationCallback(inj2875_HomePageImpl, new InitializationCallback<HomePageImpl>() {
        public void init(HomePageImpl obj) {
          com_logikas_samples_errai_client_view_layout_impl_HomePageImplTemplateResource var22 = GWT.create(com_logikas_samples_errai_client_view_layout_impl_HomePageImplTemplateResource.class);
          Element var23 = TemplateUtil.getRootTemplateElement(var22.getContents().getText(), "");
          Map<String, Element> var24 = TemplateUtil.getDataFieldElements(var23);
          Map<String, Widget> var25 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj2875_HomePageImpl, var23, var25.values());
        }
      });
      context.addInitializationCallback(inj2875_HomePageImpl, init_inj2875_HomePageImpl);
      return inj2875_HomePageImpl;
    }
  };
  private final CreationalCallback<CenterActivityMapper> inj4127_CenterActivityMapper_creational = new CreationalCallback<CenterActivityMapper>() {
    public CenterActivityMapper getInstance(final CreationalContext context) {
      final Provider<LoginActivity> var26 = inj4097_InstanceProvider.provide(new Class[] { LoginActivity.class }, null);
      final CenterActivityMapper inj4126_CenterActivityMapper = new CenterActivityMapper(var26);
      context.addBean(context.getBeanReference(CenterActivityMapper.class, arrayOf_19635043Annotation_30012296), inj4126_CenterActivityMapper);
      return inj4126_CenterActivityMapper;
    }
  };
  private final CenterActivityMapper inj4126_CenterActivityMapper = inj4127_CenterActivityMapper_creational.getInstance(context);
  private final CreationalCallback<CallerProvider> inj4128_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj4103_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_30012296), inj4103_CallerProvider);
      return inj4103_CallerProvider;
    }
  };
  private final CallerProvider inj4103_CallerProvider = inj4128_CallerProvider_creational.getInstance(context);
  private final CreationalCallback<LoginUserWidget> inj4130_LoginUserWidget_creational = new CreationalCallback<LoginUserWidget>() {
    public LoginUserWidget getInstance(final CreationalContext context) {
      final LoginUserWidget inj4129_LoginUserWidget = new LoginUserWidget();
      context.addBean(context.getBeanReference(LoginUserWidget.class, arrayOf_19635043Annotation_11096404), inj4129_LoginUserWidget);
      return inj4129_LoginUserWidget;
    }
  };
  private final LoginUserWidget inj4129_LoginUserWidget = inj4130_LoginUserWidget_creational.getInstance(context);
  private InitializationCallback<LoginActivity> init_inj4131_LoginActivity = new InitializationCallback<LoginActivity>() {
    public void init(final LoginActivity obj) {
      _$1378313608_init(obj);
    }
  };
  private final CreationalCallback<LoginActivity> inj4132_LoginActivity_creational = new CreationalCallback<LoginActivity>() {
    public LoginActivity getInstance(final CreationalContext context) {
      final LoginUserView var27 = inj4129_LoginUserWidget;
      final LoginActivity inj4131_LoginActivity = new LoginActivity(var27);
      context.addBean(context.getBeanReference(LoginActivity.class, arrayOf_19635043Annotation_30012296), inj4131_LoginActivity);
      context.addInitializationCallback(inj4131_LoginActivity, init_inj4131_LoginActivity);
      return inj4131_LoginActivity;
    }
  };
  private final CreationalCallback<MainLayoutImpl> inj4134_MainLayoutImpl_creational = new CreationalCallback<MainLayoutImpl>() {
    public MainLayoutImpl getInstance(final CreationalContext context) {
      final MainLayoutImpl inj4133_MainLayoutImpl = new MainLayoutImpl();
      context.addBean(context.getBeanReference(MainLayoutImpl.class, arrayOf_19635043Annotation_30012296), inj4133_MainLayoutImpl);
      context.addInitializationCallback(inj4133_MainLayoutImpl, new InitializationCallback<MainLayoutImpl>() {
        public void init(MainLayoutImpl obj) {
          com_logikas_samples_errai_client_view_layout_impl_MainLayoutImplTemplateResource var28 = GWT.create(com_logikas_samples_errai_client_view_layout_impl_MainLayoutImplTemplateResource.class);
          Element var29 = TemplateUtil.getRootTemplateElement(var28.getContents().getText(), "");
          Map<String, Element> var30 = TemplateUtil.getDataFieldElements(var29);
          Map<String, Widget> var31 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj4133_MainLayoutImpl, var29, var31.values());
        }
      });
      return inj4133_MainLayoutImpl;
    }
  };
  private final MainLayoutImpl inj4133_MainLayoutImpl = inj4134_MainLayoutImpl_creational.getInstance(context);
  private final CreationalCallback<ListWidgetProvider> inj4135_ListWidgetProvider_creational = new CreationalCallback<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj4085_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, arrayOf_19635043Annotation_30012296), inj4085_ListWidgetProvider);
      return inj4085_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj4085_ListWidgetProvider = inj4135_ListWidgetProvider_creational.getInstance(context);
  private InitializationCallback<MVPInitializer> init_inj4136_MVPInitializer = new InitializationCallback<MVPInitializer>() {
    public void init(final MVPInitializer obj) {
      _$1880957021_init(obj);
    }
  };
  private final CreationalCallback<MVPInitializer> inj4137_MVPInitializer_creational = new CreationalCallback<MVPInitializer>() {
    public MVPInitializer getInstance(final CreationalContext context) {
      final MVPInitializer inj4136_MVPInitializer = new MVPInitializer();
      context.addBean(context.getBeanReference(MVPInitializer.class, arrayOf_19635043Annotation_30012296), inj4136_MVPInitializer);
      context.addInitializationCallback(inj4136_MVPInitializer, init_inj4136_MVPInitializer);
      return inj4136_MVPInitializer;
    }
  };
  private final MVPInitializer inj4136_MVPInitializer = inj4137_MVPInitializer_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj4138_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj4105_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_30012296), inj4105_DisposerProvider);
      _$1300398733_beanManager(inj4105_DisposerProvider, inj4093_IOCBeanManagerProvider.get());
      return inj4105_DisposerProvider;
    }
  };
  private final DisposerProvider inj4105_DisposerProvider = inj4138_DisposerProvider_creational.getInstance(context);
  public interface com_logikas_samples_errai_client_view_layout_impl_PageLayoutImplTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/samples/errai/client/view/layout/impl/PageLayoutImpl.html") public TextResource getContents(); }
  public interface com_logikas_samples_errai_client_view_layout_impl_HomePageImplTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/samples/errai/client/view/layout/impl/HomePageImpl.html") public TextResource getContents(); }
  public interface com_logikas_samples_errai_client_view_layout_impl_MainLayoutImplTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/samples/errai/client/view/layout/impl/MainLayoutImpl.html") public TextResource getContents(); }
  private void declareBeans_0() {
    injContext.addBean(CenterActivityManagerProvider.class, CenterActivityManagerProvider.class, inj4110_CenterActivityManagerProvider_creational, inj4109_CenterActivityManagerProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(Provider.class, CenterActivityManagerProvider.class, inj4110_CenterActivityManagerProvider_creational, inj4109_CenterActivityManagerProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj4111_DataBinderProvider_creational, inj4095_DataBinderProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj4111_DataBinderProvider_creational, inj4095_DataBinderProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj4112_RequestDispatcherProvider_creational, inj4089_RequestDispatcherProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj4112_RequestDispatcherProvider_creational, inj4089_RequestDispatcherProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj4113_InstanceProvider_creational, inj4097_InstanceProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj4113_InstanceProvider_creational, inj4097_InstanceProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj4114_RootPanelProvider_creational, inj4091_RootPanelProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj4114_RootPanelProvider_creational, inj4091_RootPanelProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj4115_IOCBeanManagerProvider_creational, inj4093_IOCBeanManagerProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj4115_IOCBeanManagerProvider_creational, inj4093_IOCBeanManagerProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj4116_MessageBusProvider_creational, inj4087_MessageBusProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj4116_MessageBusProvider_creational, inj4087_MessageBusProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(App.class, App.class, inj4118_App_creational, inj4117_App, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(EventProvider.class, EventProvider.class, inj4119_EventProvider_creational, inj4101_EventProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj4119_EventProvider_creational, inj4101_EventProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj4120_SenderProvider_creational, inj4107_SenderProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj4120_SenderProvider_creational, inj4107_SenderProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj4121_InitBallotProvider_creational, inj4099_InitBallotProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj4121_InitBallotProvider_creational, inj4099_InitBallotProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(PageLayoutImpl.class, PageLayoutImpl.class, inj4124_PageLayoutImpl_creational, null, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(HomePageImpl.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(HomePage.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(PageLayoutImpl.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(PageLayout.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(IsWidget.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(Composite.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(IsRenderable.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(Widget.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(EventListener.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(HasAttachHandlers.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(HasHandlers.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(UIObject.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(HasVisibility.class, HomePageImpl.class, inj4125_HomePageImpl_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(CenterActivityMapper.class, CenterActivityMapper.class, inj4127_CenterActivityMapper_creational, inj4126_CenterActivityMapper, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(ActivityMapper.class, CenterActivityMapper.class, inj4127_CenterActivityMapper_creational, inj4126_CenterActivityMapper, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj4128_CallerProvider_creational, inj4103_CallerProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj4128_CallerProvider_creational, inj4103_CallerProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(LoginUserWidget.class, LoginUserWidget.class, inj4130_LoginUserWidget_creational, inj4129_LoginUserWidget, arrayOf_19635043Annotation_11096404, null, true);
    injContext.addBean(LoginUserView.class, LoginUserWidget.class, inj4130_LoginUserWidget_creational, inj4129_LoginUserWidget, arrayOf_19635043Annotation_11096404, null, false);
    injContext.addBean(IsWidget.class, LoginUserWidget.class, inj4130_LoginUserWidget_creational, inj4129_LoginUserWidget, arrayOf_19635043Annotation_11096404, null, false);
    injContext.addBean(LoginActivity.class, LoginActivity.class, inj4132_LoginActivity_creational, null, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(Presenter.class, LoginActivity.class, inj4132_LoginActivity_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(AbstractActivity.class, LoginActivity.class, inj4132_LoginActivity_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(Activity.class, LoginActivity.class, inj4132_LoginActivity_creational, null, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(MainLayoutImpl.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(Composite.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(IsRenderable.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(Widget.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(EventListener.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(HasAttachHandlers.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(HasHandlers.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(IsWidget.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(UIObject.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(HasVisibility.class, MainLayoutImpl.class, inj4134_MainLayoutImpl_creational, inj4133_MainLayoutImpl, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj4135_ListWidgetProvider_creational, inj4085_ListWidgetProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj4135_ListWidgetProvider_creational, inj4085_ListWidgetProvider, arrayOf_19635043Annotation_30012296, null, false);
    injContext.addBean(MVPInitializer.class, MVPInitializer.class, inj4137_MVPInitializer_creational, inj4136_MVPInitializer, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj4138_DisposerProvider_creational, inj4105_DisposerProvider, arrayOf_19635043Annotation_30012296, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj4138_DisposerProvider_creational, inj4105_DisposerProvider, arrayOf_19635043Annotation_30012296, null, false);
  }

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _$295373500_eventBus(App instance, Provider value) /*-{
    instance.@com.logikas.samples.errai.client.local.App::eventBus = value;
  }-*/;

  public native static EventBus _$295373500_produceMyBean(App instance) /*-{
    return instance.@com.logikas.samples.errai.client.local.App::produceMyBean()();
  }-*/;

  public native static void _$1378313608_init(LoginActivity instance) /*-{
    instance.@com.logikas.samples.errai.client.presenter.LoginActivity::init()();
  }-*/;

  public native static void _$1880957021_init(MVPInitializer instance) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::init()();
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    final CreationalCallback<EventBus> var32 = new CreationalCallback<EventBus>() {
      public EventBus getInstance(CreationalContext pContext) {
        EventBus var32 = inj4136_MVPInitializer.getEventBus();
        context.addBean(context.getBeanReference(EventBus.class, arrayOf_19635043Annotation_30012296), var32);
        return var32;
      }
    };
    final CreationalCallback<EventBus> var33 = new CreationalCallback<EventBus>() {
      public EventBus getInstance(CreationalContext pContext) {
        EventBus var33 = _$295373500_produceMyBean(inj4117_App);
        context.addBean(context.getBeanReference(EventBus.class, arrayOf_19635043Annotation_30012296), var33);
        return var33;
      }
    };
    final CreationalCallback<EventBus> var34 = new CreationalCallback<EventBus>() {
      public EventBus getInstance(CreationalContext pContext) {
        EventBus var34 = inj4136_MVPInitializer.getEventBus();
        context.addBean(context.getBeanReference(EventBus.class, arrayOf_19635043Annotation_30012296), var34);
        return var34;
      }
    };
    final CreationalCallback<EventBus> var35 = new CreationalCallback<EventBus>() {
      public EventBus getInstance(CreationalContext pContext) {
        EventBus var35 = _$295373500_produceMyBean(inj4117_App);
        context.addBean(context.getBeanReference(EventBus.class, arrayOf_19635043Annotation_30012296), var35);
        return var35;
      }
    };
    declareBeans_0();
    return injContext;
  }
}