package org.jboss.errai.ioc.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
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
import javax.enterprise.inject.Instance;
import javax.inject.Provider;
import org.jboss.errai.databinding.client.DataBinderProvider;
import org.jboss.errai.databinding.client.DataBindingModuleBootstrapper;
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
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.jboss.errai.ioc.client.container.InitializationCallback;
import org.jboss.errai.ui.client.widget.ListWidgetProvider;
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;

public class BootstrapperImpl implements Bootstrapper {
  {
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
    new JaxrsModuleBootstrapper().run();
  }
  private final Default _1998831462Default_18768679 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Any _1998831462Any_33530976 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_28758915 = new Annotation[] { _1998831462Default_18768679, _1998831462Any_33530976 };
  private final LoadAsync _1369430986LoadAsync_0 = new LoadAsync() {
    public Class annotationType() {
      return LoadAsync.class;
    }
    public String toString() {
      return "@org.jboss.errai.ioc.client.api.LoadAsync()";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_29684577 = new Annotation[] { _1369430986LoadAsync_0, _1998831462Any_33530976 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<CenterActivityManagerProvider> inj41207_CenterActivityManagerProvider_creational = new CreationalCallback<CenterActivityManagerProvider>() {
    public CenterActivityManagerProvider getInstance(final CreationalContext context) {
      final CenterActivityManagerProvider inj41206_CenterActivityManagerProvider = new CenterActivityManagerProvider();
      context.addBean(context.getBeanReference(CenterActivityManagerProvider.class, arrayOf_19635043Annotation_28758915), inj41206_CenterActivityManagerProvider);
      return inj41206_CenterActivityManagerProvider;
    }
  };
  private final CenterActivityManagerProvider inj41206_CenterActivityManagerProvider = inj41207_CenterActivityManagerProvider_creational.getInstance(context);
  private final CreationalCallback<DataBinderProvider> inj41208_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj41192_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_28758915), inj41192_DataBinderProvider);
      return inj41192_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj41192_DataBinderProvider = inj41208_DataBinderProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj41209_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj41186_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_28758915), inj41186_RequestDispatcherProvider);
      return inj41186_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj41186_RequestDispatcherProvider = inj41209_RequestDispatcherProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj41210_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj41194_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_28758915), inj41194_InstanceProvider);
      return inj41194_InstanceProvider;
    }
  };
  private final InstanceProvider inj41194_InstanceProvider = inj41210_InstanceProvider_creational.getInstance(context);
  private final CreationalCallback<RootPanelProvider> inj41212_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj41188_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_28758915), inj41188_RootPanelProvider);
      return inj41188_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj41188_RootPanelProvider = inj41212_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj41213_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj41190_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_28758915), inj41190_IOCBeanManagerProvider);
      return inj41190_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj41190_IOCBeanManagerProvider = inj41213_IOCBeanManagerProvider_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj41214_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj41184_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_28758915), inj41184_MessageBusProvider);
      return inj41184_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj41184_MessageBusProvider = inj41214_MessageBusProvider_creational.getInstance(context);
  private InitializationCallback<MVPInitializer> init_inj41211_MVPInitializer = new InitializationCallback<MVPInitializer>() {
    public void init(final MVPInitializer obj) {
      _$1880957021_init(obj);
    }
  };
  private final CreationalCallback<MVPInitializer> inj41215_MVPInitializer_creational = new CreationalCallback<MVPInitializer>() {
    public MVPInitializer getInstance(final CreationalContext context) {
      final MVPInitializer inj41211_MVPInitializer = new MVPInitializer();
      context.addBean(context.getBeanReference(MVPInitializer.class, arrayOf_19635043Annotation_28758915), inj41211_MVPInitializer);
      _$1880957021_actMapper(inj41211_MVPInitializer, inj41194_InstanceProvider.provide(new Class[] { CenterActivityMapper.class }, null));
      _$1880957021_bus(inj41211_MVPInitializer, inj41194_InstanceProvider.provide(new Class[] { EventBus.class }, null));
      _$1880957021_centerActivityManager(inj41211_MVPInitializer, inj41194_InstanceProvider.provide(new Class[] { ActivityManager.class }, null));
      context.addInitializationCallback(inj41211_MVPInitializer, init_inj41211_MVPInitializer);
      return inj41211_MVPInitializer;
    }
  };
  private final MVPInitializer inj41211_MVPInitializer = inj41215_MVPInitializer_creational.getInstance(context);
  private InitializationCallback<App> init_inj41216_App = new InitializationCallback<App>() {
    public void init(final App obj) {
      obj.init();
    }
  };
  private final CreationalCallback<App> inj41217_App_creational = new CreationalCallback<App>() {
    public App getInstance(final CreationalContext context) {
      final App inj41216_App = new App();
      context.addBean(context.getBeanReference(App.class, arrayOf_19635043Annotation_28758915), inj41216_App);
      _$295373500_activityInitializer(inj41216_App, inj41211_MVPInitializer);
      context.addInitializationCallback(inj41216_App, init_inj41216_App);
      return inj41216_App;
    }
  };
  private final App inj41216_App = inj41217_App_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj41218_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj41198_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_28758915), inj41198_EventProvider);
      return inj41198_EventProvider;
    }
  };
  private final EventProvider inj41198_EventProvider = inj41218_EventProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj41219_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj41204_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_28758915), inj41204_SenderProvider);
      return inj41204_SenderProvider;
    }
  };
  private final SenderProvider inj41204_SenderProvider = inj41219_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj41220_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj41196_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_28758915), inj41196_InitBallotProvider);
      return inj41196_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj41196_InitBallotProvider = inj41220_InitBallotProvider_creational.getInstance(context);
  private InitializationCallback<PageLayoutImpl> init_inj41222_PageLayoutImpl = new InitializationCallback<PageLayoutImpl>() {
    public void init(final PageLayoutImpl obj) {
      obj.init();
    }
  };
  private final CreationalCallback<PageLayoutImpl> inj41223_PageLayoutImpl_creational = new CreationalCallback<PageLayoutImpl>() {
    public PageLayoutImpl getInstance(final CreationalContext context) {
      final PageLayoutImpl inj41222_PageLayoutImpl = new PageLayoutImpl();
      context.addBean(context.getBeanReference(PageLayoutImpl.class, arrayOf_19635043Annotation_28758915), inj41222_PageLayoutImpl);
      context.addInitializationCallback(inj41222_PageLayoutImpl, new InitializationCallback<PageLayoutImpl>() {
        public void init(PageLayoutImpl obj) {
          com_logikas_samples_errai_client_view_layout_impl_PageLayoutImplTemplateResource var220 = GWT.create(com_logikas_samples_errai_client_view_layout_impl_PageLayoutImplTemplateResource.class);
          Element var221 = TemplateUtil.getRootTemplateElement(var220.getContents().getText(), "");
          Map<String, Element> var222 = TemplateUtil.getDataFieldElements(var221);
          Map<String, Widget> var223 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj41222_PageLayoutImpl, var221, var223.values());
        }
      });
      context.addInitializationCallback(inj41222_PageLayoutImpl, init_inj41222_PageLayoutImpl);
      return inj41222_PageLayoutImpl;
    }
  };
  private InitializationCallback<HomePageImpl> init_inj39973_HomePageImpl = new InitializationCallback<HomePageImpl>() {
    public void init(final HomePageImpl obj) {
      obj.init();
    }
  };
  private final CreationalCallback<HomePageImpl> inj41224_HomePageImpl_creational = new CreationalCallback<HomePageImpl>() {
    public HomePageImpl getInstance(final CreationalContext context) {
      final HomePageImpl inj39973_HomePageImpl = new HomePageImpl();
      context.addBean(context.getBeanReference(HomePageImpl.class, arrayOf_19635043Annotation_28758915), inj39973_HomePageImpl);
      context.addInitializationCallback(inj39973_HomePageImpl, new InitializationCallback<HomePageImpl>() {
        public void init(HomePageImpl obj) {
          com_logikas_samples_errai_client_view_layout_impl_HomePageImplTemplateResource var224 = GWT.create(com_logikas_samples_errai_client_view_layout_impl_HomePageImplTemplateResource.class);
          Element var225 = TemplateUtil.getRootTemplateElement(var224.getContents().getText(), "");
          Map<String, Element> var226 = TemplateUtil.getDataFieldElements(var225);
          Map<String, Widget> var227 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj39973_HomePageImpl, var225, var227.values());
        }
      });
      context.addInitializationCallback(inj39973_HomePageImpl, init_inj39973_HomePageImpl);
      return inj39973_HomePageImpl;
    }
  };
  private final CreationalCallback<CenterActivityMapper> inj41226_CenterActivityMapper_creational = new CreationalCallback<CenterActivityMapper>() {
    public CenterActivityMapper getInstance(final CreationalContext context) {
      final Provider<LoginActivity> var228 = inj41194_InstanceProvider.provide(new Class[] { LoginActivity.class }, null);
      final CenterActivityMapper inj41225_CenterActivityMapper = new CenterActivityMapper(var228);
      context.addBean(context.getBeanReference(CenterActivityMapper.class, arrayOf_19635043Annotation_28758915), inj41225_CenterActivityMapper);
      return inj41225_CenterActivityMapper;
    }
  };
  private final CenterActivityMapper inj41225_CenterActivityMapper = inj41226_CenterActivityMapper_creational.getInstance(context);
  private final CreationalCallback<CallerProvider> inj41227_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj41200_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_28758915), inj41200_CallerProvider);
      return inj41200_CallerProvider;
    }
  };
  private final CallerProvider inj41200_CallerProvider = inj41227_CallerProvider_creational.getInstance(context);
  private final CreationalCallback<LoginUserWidget> inj41229_LoginUserWidget_creational = new CreationalCallback<LoginUserWidget>() {
    public LoginUserWidget getInstance(final CreationalContext context) {
      final LoginUserWidget inj41228_LoginUserWidget = new LoginUserWidget();
      context.addBean(context.getBeanReference(LoginUserWidget.class, arrayOf_19635043Annotation_29684577), inj41228_LoginUserWidget);
      return inj41228_LoginUserWidget;
    }
  };
  private final LoginUserWidget inj41228_LoginUserWidget = inj41229_LoginUserWidget_creational.getInstance(context);
  private InitializationCallback<LoginActivity> init_inj41230_LoginActivity = new InitializationCallback<LoginActivity>() {
    public void init(final LoginActivity obj) {
      _$1378313608_init(obj);
    }
  };
  private final CreationalCallback<LoginActivity> inj41231_LoginActivity_creational = new CreationalCallback<LoginActivity>() {
    public LoginActivity getInstance(final CreationalContext context) {
      final LoginUserView var229 = inj41228_LoginUserWidget;
      final LoginActivity inj41230_LoginActivity = new LoginActivity(var229);
      context.addBean(context.getBeanReference(LoginActivity.class, arrayOf_19635043Annotation_28758915), inj41230_LoginActivity);
      context.addInitializationCallback(inj41230_LoginActivity, init_inj41230_LoginActivity);
      return inj41230_LoginActivity;
    }
  };
  private final CreationalCallback<MainLayoutImpl> inj41233_MainLayoutImpl_creational = new CreationalCallback<MainLayoutImpl>() {
    public MainLayoutImpl getInstance(final CreationalContext context) {
      final MainLayoutImpl inj41232_MainLayoutImpl = new MainLayoutImpl();
      context.addBean(context.getBeanReference(MainLayoutImpl.class, arrayOf_19635043Annotation_28758915), inj41232_MainLayoutImpl);
      context.addInitializationCallback(inj41232_MainLayoutImpl, new InitializationCallback<MainLayoutImpl>() {
        public void init(MainLayoutImpl obj) {
          com_logikas_samples_errai_client_view_layout_impl_MainLayoutImplTemplateResource var230 = GWT.create(com_logikas_samples_errai_client_view_layout_impl_MainLayoutImplTemplateResource.class);
          Element var231 = TemplateUtil.getRootTemplateElement(var230.getContents().getText(), "");
          Map<String, Element> var232 = TemplateUtil.getDataFieldElements(var231);
          Map<String, Widget> var233 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj41232_MainLayoutImpl, var231, var233.values());
        }
      });
      return inj41232_MainLayoutImpl;
    }
  };
  private final MainLayoutImpl inj41232_MainLayoutImpl = inj41233_MainLayoutImpl_creational.getInstance(context);
  private final CreationalCallback<ListWidgetProvider> inj41234_ListWidgetProvider_creational = new CreationalCallback<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj41182_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, arrayOf_19635043Annotation_28758915), inj41182_ListWidgetProvider);
      return inj41182_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj41182_ListWidgetProvider = inj41234_ListWidgetProvider_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj41235_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj41202_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_28758915), inj41202_DisposerProvider);
      _$1300398733_beanManager(inj41202_DisposerProvider, inj41190_IOCBeanManagerProvider.get());
      return inj41202_DisposerProvider;
    }
  };
  private final DisposerProvider inj41202_DisposerProvider = inj41235_DisposerProvider_creational.getInstance(context);
  public interface com_logikas_samples_errai_client_view_layout_impl_PageLayoutImplTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/samples/errai/client/view/layout/impl/PageLayoutImpl.html") public TextResource getContents(); }
  public interface com_logikas_samples_errai_client_view_layout_impl_HomePageImplTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/samples/errai/client/view/layout/impl/HomePageImpl.html") public TextResource getContents(); }
  public interface com_logikas_samples_errai_client_view_layout_impl_MainLayoutImplTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/samples/errai/client/view/layout/impl/MainLayoutImpl.html") public TextResource getContents(); }
  private void declareBeans_0() {
    injContext.addBean(CenterActivityManagerProvider.class, CenterActivityManagerProvider.class, inj41207_CenterActivityManagerProvider_creational, inj41206_CenterActivityManagerProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(Provider.class, CenterActivityManagerProvider.class, inj41207_CenterActivityManagerProvider_creational, inj41206_CenterActivityManagerProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj41208_DataBinderProvider_creational, inj41192_DataBinderProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj41208_DataBinderProvider_creational, inj41192_DataBinderProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj41209_RequestDispatcherProvider_creational, inj41186_RequestDispatcherProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj41209_RequestDispatcherProvider_creational, inj41186_RequestDispatcherProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj41210_InstanceProvider_creational, inj41194_InstanceProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj41210_InstanceProvider_creational, inj41194_InstanceProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj41212_RootPanelProvider_creational, inj41188_RootPanelProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj41212_RootPanelProvider_creational, inj41188_RootPanelProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj41213_IOCBeanManagerProvider_creational, inj41190_IOCBeanManagerProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj41213_IOCBeanManagerProvider_creational, inj41190_IOCBeanManagerProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj41214_MessageBusProvider_creational, inj41184_MessageBusProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj41214_MessageBusProvider_creational, inj41184_MessageBusProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(MVPInitializer.class, MVPInitializer.class, inj41215_MVPInitializer_creational, inj41211_MVPInitializer, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(App.class, App.class, inj41217_App_creational, inj41216_App, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(EventProvider.class, EventProvider.class, inj41218_EventProvider_creational, inj41198_EventProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj41218_EventProvider_creational, inj41198_EventProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj41219_SenderProvider_creational, inj41204_SenderProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj41219_SenderProvider_creational, inj41204_SenderProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj41220_InitBallotProvider_creational, inj41196_InitBallotProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj41220_InitBallotProvider_creational, inj41196_InitBallotProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(PageLayoutImpl.class, PageLayoutImpl.class, inj41223_PageLayoutImpl_creational, null, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(HomePageImpl.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(HomePage.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(PageLayoutImpl.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(PageLayout.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(IsWidget.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(Composite.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(IsRenderable.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(Widget.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(EventListener.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(HasAttachHandlers.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(HasHandlers.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(UIObject.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(HasVisibility.class, HomePageImpl.class, inj41224_HomePageImpl_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(CenterActivityMapper.class, CenterActivityMapper.class, inj41226_CenterActivityMapper_creational, inj41225_CenterActivityMapper, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(ActivityMapper.class, CenterActivityMapper.class, inj41226_CenterActivityMapper_creational, inj41225_CenterActivityMapper, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj41227_CallerProvider_creational, inj41200_CallerProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj41227_CallerProvider_creational, inj41200_CallerProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(LoginUserWidget.class, LoginUserWidget.class, inj41229_LoginUserWidget_creational, inj41228_LoginUserWidget, arrayOf_19635043Annotation_29684577, null, true);
    injContext.addBean(LoginUserView.class, LoginUserWidget.class, inj41229_LoginUserWidget_creational, inj41228_LoginUserWidget, arrayOf_19635043Annotation_29684577, null, false);
    injContext.addBean(IsWidget.class, LoginUserWidget.class, inj41229_LoginUserWidget_creational, inj41228_LoginUserWidget, arrayOf_19635043Annotation_29684577, null, false);
    injContext.addBean(LoginActivity.class, LoginActivity.class, inj41231_LoginActivity_creational, null, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(Presenter.class, LoginActivity.class, inj41231_LoginActivity_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(AbstractActivity.class, LoginActivity.class, inj41231_LoginActivity_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(Activity.class, LoginActivity.class, inj41231_LoginActivity_creational, null, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(MainLayoutImpl.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(Composite.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(IsRenderable.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(Widget.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(EventListener.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(HasAttachHandlers.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(HasHandlers.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(IsWidget.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(UIObject.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(HasVisibility.class, MainLayoutImpl.class, inj41233_MainLayoutImpl_creational, inj41232_MainLayoutImpl, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj41234_ListWidgetProvider_creational, inj41182_ListWidgetProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj41234_ListWidgetProvider_creational, inj41182_ListWidgetProvider, arrayOf_19635043Annotation_28758915, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj41235_DisposerProvider_creational, inj41202_DisposerProvider, arrayOf_19635043Annotation_28758915, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj41235_DisposerProvider_creational, inj41202_DisposerProvider, arrayOf_19635043Annotation_28758915, null, false);
  }

  private native static void _$295373500_activityInitializer(App instance, MVPInitializer value) /*-{
    instance.@com.logikas.samples.errai.client.local.App::activityInitializer = value;
  }-*/;

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _$1880957021_centerActivityManager(MVPInitializer instance, Instance value) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::centerActivityManager = value;
  }-*/;

  private native static void _$1880957021_bus(MVPInitializer instance, Provider value) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::bus = value;
  }-*/;

  private native static void _$1880957021_actMapper(MVPInitializer instance, Provider value) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::actMapper = value;
  }-*/;

  public native static void _$1880957021_init(MVPInitializer instance) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::init()();
  }-*/;

  public native static void _$1378313608_init(LoginActivity instance) /*-{
    instance.@com.logikas.samples.errai.client.presenter.LoginActivity::init()();
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    final CreationalCallback<EventBus> var234 = new CreationalCallback<EventBus>() {
      public EventBus getInstance(CreationalContext pContext) {
        EventBus var234 = inj41211_MVPInitializer.getEventBus();
        context.addBean(context.getBeanReference(EventBus.class, arrayOf_19635043Annotation_28758915), var234);
        return var234;
      }
    };
    declareBeans_0();
    return injContext;
  }
}