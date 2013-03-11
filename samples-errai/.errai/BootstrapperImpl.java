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
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
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
import com.logikas.samples.errai.client.presenter.configure.CenterActivityMapper;
import com.logikas.samples.errai.client.presenter.configure.CenterRegion;
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
  private final Any _1998831462Any_1297791937 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Default _1998831462Default_1509717206 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_2021420287 = new Annotation[] { _1998831462Any_1297791937, _1998831462Default_1509717206 };
  private final CenterRegion _$1071743002CenterRegion_0 = new CenterRegion() {
    public Class annotationType() {
      return CenterRegion.class;
    }
    public String toString() {
      return "@com.logikas.samples.errai.client.presenter.configure.CenterRegion()";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_357172536 = new Annotation[] { _$1071743002CenterRegion_0, _1998831462Any_1297791937 };
  private final LoadAsync _1369430986LoadAsync_0 = new LoadAsync() {
    public Class annotationType() {
      return LoadAsync.class;
    }
    public String toString() {
      return "@org.jboss.errai.ioc.client.api.LoadAsync()";
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1070652855 = new Annotation[] { _1369430986LoadAsync_0, _1998831462Any_1297791937 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<RootPanelProvider> inj14367_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj14349_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_2021420287), inj14349_RootPanelProvider);
      return inj14349_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj14349_RootPanelProvider = inj14367_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj14368_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj14351_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_2021420287), inj14351_IOCBeanManagerProvider);
      return inj14351_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj14351_IOCBeanManagerProvider = inj14368_IOCBeanManagerProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj14369_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj14355_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_2021420287), inj14355_InstanceProvider);
      return inj14355_InstanceProvider;
    }
  };
  private final InstanceProvider inj14355_InstanceProvider = inj14369_InstanceProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj14370_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj14347_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_2021420287), inj14347_RequestDispatcherProvider);
      return inj14347_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj14347_RequestDispatcherProvider = inj14370_RequestDispatcherProvider_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj14371_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj14345_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_2021420287), inj14345_MessageBusProvider);
      return inj14345_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj14345_MessageBusProvider = inj14371_MessageBusProvider_creational.getInstance(context);
  private final CreationalCallback<CenterActivityMapper> inj14373_CenterActivityMapper_creational = new CreationalCallback<CenterActivityMapper>() {
    public CenterActivityMapper getInstance(final CreationalContext context) {
      final Provider<LoginActivity> var51 = inj14355_InstanceProvider.provide(new Class[] { LoginActivity.class }, null);
      final CenterActivityMapper inj14372_CenterActivityMapper = new CenterActivityMapper(var51);
      context.addBean(context.getBeanReference(CenterActivityMapper.class, arrayOf_19635043Annotation_2021420287), inj14372_CenterActivityMapper);
      return inj14372_CenterActivityMapper;
    }
  };
  private final CenterActivityMapper inj14372_CenterActivityMapper = inj14373_CenterActivityMapper_creational.getInstance(context);
  private InitializationCallback<MVPInitializer> init_inj14366_MVPInitializer = new InitializationCallback<MVPInitializer>() {
    public void init(final MVPInitializer obj) {
      _$1880957021_init(obj);
    }
  };
  private final CreationalCallback<MVPInitializer> inj14374_MVPInitializer_creational = new CreationalCallback<MVPInitializer>() {
    public MVPInitializer getInstance(final CreationalContext context) {
      final MVPInitializer inj14366_MVPInitializer = new MVPInitializer();
      context.addBean(context.getBeanReference(MVPInitializer.class, arrayOf_19635043Annotation_2021420287), inj14366_MVPInitializer);
      final CreationalCallback<EventBus> var52 = new CreationalCallback<EventBus>() {
        public EventBus getInstance(CreationalContext pContext) {
          EventBus var52 = inj14366_MVPInitializer.getEventBus();
          context.addBean(context.getBeanReference(EventBus.class, arrayOf_19635043Annotation_2021420287), var52);
          return var52;
        }
      };
      _$1880957021_bus(inj14366_MVPInitializer, context.getSingletonInstanceOrNew(injContext, var52, EventBus.class, arrayOf_19635043Annotation_2021420287));
      final CreationalCallback<EventBus> var54 = new CreationalCallback<EventBus>() {
        public EventBus getInstance(CreationalContext pContext) {
          EventBus var54 = inj14366_MVPInitializer.getEventBus();
          context.addBean(context.getBeanReference(EventBus.class, arrayOf_19635043Annotation_2021420287), var54);
          return var54;
        }
      };
      final EventBus var55 = context.getSingletonInstanceOrNew(injContext, var54, EventBus.class, arrayOf_19635043Annotation_2021420287);
      final CreationalCallback<PlaceController> var53 = new CreationalCallback<PlaceController>() {
        public PlaceController getInstance(CreationalContext pContext) {
          PlaceController var53 = inj14366_MVPInitializer.getPlaceController(var55);
          context.addBean(context.getBeanReference(PlaceController.class, arrayOf_19635043Annotation_2021420287), var53);
          return var53;
        }
      };
      _$1880957021_controller(inj14366_MVPInitializer, context.getSingletonInstanceOrNew(injContext, var53, PlaceController.class, arrayOf_19635043Annotation_2021420287));
      _$1880957021_mapper(inj14366_MVPInitializer, inj14372_CenterActivityMapper);
      final CreationalCallback<ActivityManager> var56 = new CreationalCallback<ActivityManager>() {
        public ActivityManager getInstance(CreationalContext pContext) {
          ActivityManager var56 = inj14366_MVPInitializer.getCenterActivityManager();
          context.addBean(context.getBeanReference(ActivityManager.class, arrayOf_19635043Annotation_357172536), var56);
          return var56;
        }
      };
      _$1880957021_centerActivityManager(inj14366_MVPInitializer, context.getSingletonInstanceOrNew(injContext, var56, ActivityManager.class, arrayOf_19635043Annotation_357172536));
      final CreationalCallback<PlaceHistoryHandler> var57 = new CreationalCallback<PlaceHistoryHandler>() {
        public PlaceHistoryHandler getInstance(CreationalContext pContext) {
          PlaceHistoryHandler var57 = inj14366_MVPInitializer.getHistoryHandler();
          context.addBean(context.getBeanReference(PlaceHistoryHandler.class, arrayOf_19635043Annotation_2021420287), var57);
          return var57;
        }
      };
      _$1880957021_historyHandler(inj14366_MVPInitializer, context.getSingletonInstanceOrNew(injContext, var57, PlaceHistoryHandler.class, arrayOf_19635043Annotation_2021420287));
      final CreationalCallback<PlaceHistoryMapper> var58 = new CreationalCallback<PlaceHistoryMapper>() {
        public PlaceHistoryMapper getInstance(CreationalContext pContext) {
          PlaceHistoryMapper var58 = inj14366_MVPInitializer.getHistoryMapper();
          context.addBean(context.getBeanReference(PlaceHistoryMapper.class, arrayOf_19635043Annotation_2021420287), var58);
          return var58;
        }
      };
      _$1880957021_historyMapper(inj14366_MVPInitializer, context.getSingletonInstanceOrNew(injContext, var58, PlaceHistoryMapper.class, arrayOf_19635043Annotation_2021420287));
      context.addInitializationCallback(inj14366_MVPInitializer, init_inj14366_MVPInitializer);
      return inj14366_MVPInitializer;
    }
  };
  private final MVPInitializer inj14366_MVPInitializer = inj14374_MVPInitializer_creational.getInstance(context);
  private final CreationalCallback<DataBinderProvider> inj14375_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj14353_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_2021420287), inj14353_DataBinderProvider);
      return inj14353_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj14353_DataBinderProvider = inj14375_DataBinderProvider_creational.getInstance(context);
  private InitializationCallback<App> init_inj14376_App = new InitializationCallback<App>() {
    public void init(final App obj) {
      obj.init();
    }
  };
  private final CreationalCallback<App> inj14377_App_creational = new CreationalCallback<App>() {
    public App getInstance(final CreationalContext context) {
      final App inj14376_App = new App();
      context.addBean(context.getBeanReference(App.class, arrayOf_19635043Annotation_2021420287), inj14376_App);
      _$295373500_activityInitializer(inj14376_App, inj14366_MVPInitializer);
      context.addInitializationCallback(inj14376_App, init_inj14376_App);
      return inj14376_App;
    }
  };
  private final App inj14376_App = inj14377_App_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj14378_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj14359_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_2021420287), inj14359_EventProvider);
      return inj14359_EventProvider;
    }
  };
  private final EventProvider inj14359_EventProvider = inj14378_EventProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj14379_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj14365_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_2021420287), inj14365_SenderProvider);
      return inj14365_SenderProvider;
    }
  };
  private final SenderProvider inj14365_SenderProvider = inj14379_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj14380_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj14357_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_2021420287), inj14357_InitBallotProvider);
      return inj14357_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj14357_InitBallotProvider = inj14380_InitBallotProvider_creational.getInstance(context);
  private InitializationCallback<PageLayoutImpl> init_inj14382_PageLayoutImpl = new InitializationCallback<PageLayoutImpl>() {
    public void init(final PageLayoutImpl obj) {
      obj.init();
    }
  };
  private final CreationalCallback<PageLayoutImpl> inj14383_PageLayoutImpl_creational = new CreationalCallback<PageLayoutImpl>() {
    public PageLayoutImpl getInstance(final CreationalContext context) {
      final PageLayoutImpl inj14382_PageLayoutImpl = new PageLayoutImpl();
      context.addBean(context.getBeanReference(PageLayoutImpl.class, arrayOf_19635043Annotation_2021420287), inj14382_PageLayoutImpl);
      context.addInitializationCallback(inj14382_PageLayoutImpl, new InitializationCallback<PageLayoutImpl>() {
        public void init(PageLayoutImpl obj) {
          com_logikas_samples_errai_client_view_layout_impl_PageLayoutImplTemplateResource var59 = GWT.create(com_logikas_samples_errai_client_view_layout_impl_PageLayoutImplTemplateResource.class);
          Element var60 = TemplateUtil.getRootTemplateElement(var59.getContents().getText(), "");
          Map<String, Element> var61 = TemplateUtil.getDataFieldElements(var60);
          Map<String, Widget> var62 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj14382_PageLayoutImpl, var60, var62.values());
        }
      });
      context.addInitializationCallback(inj14382_PageLayoutImpl, init_inj14382_PageLayoutImpl);
      return inj14382_PageLayoutImpl;
    }
  };
  private InitializationCallback<HomePageImpl> init_inj13130_HomePageImpl = new InitializationCallback<HomePageImpl>() {
    public void init(final HomePageImpl obj) {
      obj.init();
    }
  };
  private final CreationalCallback<HomePageImpl> inj14384_HomePageImpl_creational = new CreationalCallback<HomePageImpl>() {
    public HomePageImpl getInstance(final CreationalContext context) {
      final HomePageImpl inj13130_HomePageImpl = new HomePageImpl();
      context.addBean(context.getBeanReference(HomePageImpl.class, arrayOf_19635043Annotation_2021420287), inj13130_HomePageImpl);
      context.addInitializationCallback(inj13130_HomePageImpl, new InitializationCallback<HomePageImpl>() {
        public void init(HomePageImpl obj) {
          com_logikas_samples_errai_client_view_layout_impl_HomePageImplTemplateResource var63 = GWT.create(com_logikas_samples_errai_client_view_layout_impl_HomePageImplTemplateResource.class);
          Element var64 = TemplateUtil.getRootTemplateElement(var63.getContents().getText(), "");
          Map<String, Element> var65 = TemplateUtil.getDataFieldElements(var64);
          Map<String, Widget> var66 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj13130_HomePageImpl, var64, var66.values());
        }
      });
      context.addInitializationCallback(inj13130_HomePageImpl, init_inj13130_HomePageImpl);
      return inj13130_HomePageImpl;
    }
  };
  private final CreationalCallback<CallerProvider> inj14385_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj14361_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_2021420287), inj14361_CallerProvider);
      return inj14361_CallerProvider;
    }
  };
  private final CallerProvider inj14361_CallerProvider = inj14385_CallerProvider_creational.getInstance(context);
  private final CreationalCallback<LoginUserWidget> inj14387_LoginUserWidget_creational = new CreationalCallback<LoginUserWidget>() {
    public LoginUserWidget getInstance(final CreationalContext context) {
      final LoginUserWidget inj14386_LoginUserWidget = new LoginUserWidget();
      context.addBean(context.getBeanReference(LoginUserWidget.class, arrayOf_19635043Annotation_1070652855), inj14386_LoginUserWidget);
      return inj14386_LoginUserWidget;
    }
  };
  private final LoginUserWidget inj14386_LoginUserWidget = inj14387_LoginUserWidget_creational.getInstance(context);
  private InitializationCallback<LoginActivity> init_inj14388_LoginActivity = new InitializationCallback<LoginActivity>() {
    public void init(final LoginActivity obj) {
      _$1378313608_init(obj);
    }
  };
  private final CreationalCallback<LoginActivity> inj14389_LoginActivity_creational = new CreationalCallback<LoginActivity>() {
    public LoginActivity getInstance(final CreationalContext context) {
      final LoginUserView var67 = inj14386_LoginUserWidget;
      final LoginActivity inj14388_LoginActivity = new LoginActivity(var67);
      context.addBean(context.getBeanReference(LoginActivity.class, arrayOf_19635043Annotation_2021420287), inj14388_LoginActivity);
      context.addInitializationCallback(inj14388_LoginActivity, init_inj14388_LoginActivity);
      return inj14388_LoginActivity;
    }
  };
  private final CreationalCallback<MainLayoutImpl> inj14391_MainLayoutImpl_creational = new CreationalCallback<MainLayoutImpl>() {
    public MainLayoutImpl getInstance(final CreationalContext context) {
      final MainLayoutImpl inj14390_MainLayoutImpl = new MainLayoutImpl();
      context.addBean(context.getBeanReference(MainLayoutImpl.class, arrayOf_19635043Annotation_2021420287), inj14390_MainLayoutImpl);
      context.addInitializationCallback(inj14390_MainLayoutImpl, new InitializationCallback<MainLayoutImpl>() {
        public void init(MainLayoutImpl obj) {
          com_logikas_samples_errai_client_view_layout_impl_MainLayoutImplTemplateResource var68 = GWT.create(com_logikas_samples_errai_client_view_layout_impl_MainLayoutImplTemplateResource.class);
          Element var69 = TemplateUtil.getRootTemplateElement(var68.getContents().getText(), "");
          Map<String, Element> var70 = TemplateUtil.getDataFieldElements(var69);
          Map<String, Widget> var71 = new LinkedHashMap<String, Widget>();
          TemplateUtil.initWidget(inj14390_MainLayoutImpl, var69, var71.values());
        }
      });
      return inj14390_MainLayoutImpl;
    }
  };
  private final MainLayoutImpl inj14390_MainLayoutImpl = inj14391_MainLayoutImpl_creational.getInstance(context);
  private final CreationalCallback<ListWidgetProvider> inj14392_ListWidgetProvider_creational = new CreationalCallback<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj14343_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, arrayOf_19635043Annotation_2021420287), inj14343_ListWidgetProvider);
      return inj14343_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj14343_ListWidgetProvider = inj14392_ListWidgetProvider_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj14393_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj14363_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_2021420287), inj14363_DisposerProvider);
      _$1300398733_beanManager(inj14363_DisposerProvider, inj14351_IOCBeanManagerProvider.get());
      return inj14363_DisposerProvider;
    }
  };
  private final DisposerProvider inj14363_DisposerProvider = inj14393_DisposerProvider_creational.getInstance(context);
  public interface com_logikas_samples_errai_client_view_layout_impl_PageLayoutImplTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/samples/errai/client/view/layout/impl/PageLayoutImpl.html") public TextResource getContents(); }
  public interface com_logikas_samples_errai_client_view_layout_impl_HomePageImplTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/samples/errai/client/view/layout/impl/HomePageImpl.html") public TextResource getContents(); }
  public interface com_logikas_samples_errai_client_view_layout_impl_MainLayoutImplTemplateResource extends Template, ClientBundle {
  @Source("com/logikas/samples/errai/client/view/layout/impl/MainLayoutImpl.html") public TextResource getContents(); }
  private void declareBeans_0() {
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj14367_RootPanelProvider_creational, inj14349_RootPanelProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj14367_RootPanelProvider_creational, inj14349_RootPanelProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj14368_IOCBeanManagerProvider_creational, inj14351_IOCBeanManagerProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj14368_IOCBeanManagerProvider_creational, inj14351_IOCBeanManagerProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj14369_InstanceProvider_creational, inj14355_InstanceProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj14369_InstanceProvider_creational, inj14355_InstanceProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj14370_RequestDispatcherProvider_creational, inj14347_RequestDispatcherProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj14370_RequestDispatcherProvider_creational, inj14347_RequestDispatcherProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj14371_MessageBusProvider_creational, inj14345_MessageBusProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj14371_MessageBusProvider_creational, inj14345_MessageBusProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(CenterActivityMapper.class, CenterActivityMapper.class, inj14373_CenterActivityMapper_creational, inj14372_CenterActivityMapper, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(ActivityMapper.class, CenterActivityMapper.class, inj14373_CenterActivityMapper_creational, inj14372_CenterActivityMapper, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(MVPInitializer.class, MVPInitializer.class, inj14374_MVPInitializer_creational, inj14366_MVPInitializer, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj14375_DataBinderProvider_creational, inj14353_DataBinderProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj14375_DataBinderProvider_creational, inj14353_DataBinderProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(App.class, App.class, inj14377_App_creational, inj14376_App, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(EventProvider.class, EventProvider.class, inj14378_EventProvider_creational, inj14359_EventProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj14378_EventProvider_creational, inj14359_EventProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj14379_SenderProvider_creational, inj14365_SenderProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj14379_SenderProvider_creational, inj14365_SenderProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj14380_InitBallotProvider_creational, inj14357_InitBallotProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj14380_InitBallotProvider_creational, inj14357_InitBallotProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(PageLayoutImpl.class, PageLayoutImpl.class, inj14383_PageLayoutImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(HomePageImpl.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(HomePage.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(PageLayoutImpl.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(PageLayout.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(IsWidget.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(Composite.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(IsRenderable.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(Widget.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(EventListener.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(HasAttachHandlers.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(HasHandlers.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(UIObject.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(HasVisibility.class, HomePageImpl.class, inj14384_HomePageImpl_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj14385_CallerProvider_creational, inj14361_CallerProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj14385_CallerProvider_creational, inj14361_CallerProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(LoginUserWidget.class, LoginUserWidget.class, inj14387_LoginUserWidget_creational, inj14386_LoginUserWidget, arrayOf_19635043Annotation_1070652855, null, true);
    injContext.addBean(LoginUserView.class, LoginUserWidget.class, inj14387_LoginUserWidget_creational, inj14386_LoginUserWidget, arrayOf_19635043Annotation_1070652855, null, false);
    injContext.addBean(IsWidget.class, LoginUserWidget.class, inj14387_LoginUserWidget_creational, inj14386_LoginUserWidget, arrayOf_19635043Annotation_1070652855, null, false);
    injContext.addBean(LoginActivity.class, LoginActivity.class, inj14389_LoginActivity_creational, null, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(Presenter.class, LoginActivity.class, inj14389_LoginActivity_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(AbstractActivity.class, LoginActivity.class, inj14389_LoginActivity_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(Activity.class, LoginActivity.class, inj14389_LoginActivity_creational, null, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(MainLayoutImpl.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(Composite.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(IsRenderable.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(Widget.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(EventListener.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(HasAttachHandlers.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(HasHandlers.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(IsWidget.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(UIObject.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(HasVisibility.class, MainLayoutImpl.class, inj14391_MainLayoutImpl_creational, inj14390_MainLayoutImpl, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj14392_ListWidgetProvider_creational, inj14343_ListWidgetProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj14392_ListWidgetProvider_creational, inj14343_ListWidgetProvider, arrayOf_19635043Annotation_2021420287, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj14393_DisposerProvider_creational, inj14363_DisposerProvider, arrayOf_19635043Annotation_2021420287, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj14393_DisposerProvider_creational, inj14363_DisposerProvider, arrayOf_19635043Annotation_2021420287, null, false);
  }

  private native static void _$295373500_activityInitializer(App instance, MVPInitializer value) /*-{
    instance.@com.logikas.samples.errai.client.local.App::activityInitializer = value;
  }-*/;

  private native static void _$1880957021_historyHandler(MVPInitializer instance, PlaceHistoryHandler value) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::historyHandler = value;
  }-*/;

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _$1880957021_controller(MVPInitializer instance, PlaceController value) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::controller = value;
  }-*/;

  private native static void _$1880957021_historyMapper(MVPInitializer instance, PlaceHistoryMapper value) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::historyMapper = value;
  }-*/;

  private native static void _$1880957021_bus(MVPInitializer instance, EventBus value) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::bus = value;
  }-*/;

  private native static void _$1880957021_mapper(MVPInitializer instance, CenterActivityMapper value) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::mapper = value;
  }-*/;

  private native static void _$1880957021_centerActivityManager(MVPInitializer instance, ActivityManager value) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::centerActivityManager = value;
  }-*/;

  public native static void _$1880957021_init(MVPInitializer instance) /*-{
    instance.@com.logikas.samples.errai.client.presenter.configure.MVPInitializer::init()();
  }-*/;

  public native static void _$1378313608_init(LoginActivity instance) /*-{
    instance.@com.logikas.samples.errai.client.presenter.LoginActivity::init()();
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    declareBeans_0();
    return injContext;
  }
}