package com.metroimageview;

import android.animation.Animator;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class managed 9 different image animations randomly.
 * <p/>
 * Created by Bar Yariv on 10/27/2015.
 */
public class MetroImageView extends RelativeLayout {

    private SimpleDraweeView img1;
    private SimpleDraweeView img2;
    private List<Integer> animationsToUse = new ArrayList<>();
    private List<Uri> imagesUrls = new ArrayList<>();
    private final Random rand = new Random();
    private int counter = 1;
    private int i = 1;
    private int startDelay = 3000;
    private int animationSpeed = 1000;

    public MetroImageView(Context context) {
        super(context);
        init(context);
    }

    public MetroImageView(Context context, AttributeSet as) {
        super(context, as);
        init(context);
    }

    /**
     * Initiate the view, sets default animations to use- all.
     *
     * @param context - application context
     */
    private void init(Context context) {
        inflate(context, R.layout.metro_image_view, this);
        img1 = (SimpleDraweeView) findViewById(R.id.img1);
        img2 = (SimpleDraweeView) findViewById(R.id.img2);
        img1.setImageURI(Uri.parse(""));
        img2.setImageURI(Uri.parse(""));
        for (int i = 1; i < 10; i++)
            animationsToUse.add(i);
    }

    /**
     * @return - images urls
     */
    public List<Uri> getImagesUrls() {
        return imagesUrls;
    }

    /**
     * @param imagesUrls - to set
     */
    public void setImagesUrls(List<Uri> imagesUrls) {
        if (imagesUrls != null) {
            this.imagesUrls = imagesUrls;
            animationManager();
        }
    }

    /**
     * Sets the start delay of the animation- the time from one animation ends to next start.
     *
     * @param startDelay - time to wait in ms.
     */
    public void setStartDelay(int startDelay) {
        this.startDelay = startDelay;
    }

    /**
     * Sets the animation duration.
     *
     * @param animationSpeed - time for duration in ms.
     */
    public void setAnimationSpeed(int animationSpeed) {
        this.animationSpeed = animationSpeed;
    }

    /**
     * Setd the list of animations to use, from 9 exists animations.
     *
     * @param anim - list of animations to use.
     */
    public void setAnimationsToUse(int... anim) {
        animationsToUse = new ArrayList<>();
        for (int i = 0; i < anim.length; i++) {
            animationsToUse.add(anim[i]);
        }
    }

    /**
     * flip up animation
     *
     * @param uri - image uri to change
     */
    private void flipUpAnimation(final Uri uri) {
        if (counter % 2 == 0) {
            img1.setImageURI(uri);
            img1.animate().alpha(0).setDuration(0).setListener(null);
            img1.setX(0);
            img1.setY(0);
            img1.setRotationX(270);
            img2.setX(0);
            img2.setY(0);
            img2.setRotationX(0);
            img2.animate().rotationX(90).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                         @Override
                                                                                         public void onAnimationStart(Animator animation) {
                                                                                             img1.animate().alpha(1).setListener(null);
                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationEnd(Animator animation) {
                                                                                             img2.animate().alpha(0).rotationX(0).setDuration(0).setListener(null);
                                                                                             img1.animate().rotationX(360).setDuration(animationSpeed).setListener(new Animator.AnimatorListener() {
                                                                                                 @Override
                                                                                                 public void onAnimationStart(Animator animation) {
                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationEnd(Animator animation) {
                                                                                                     timer();
//                                                                                           img1.animate().rotationX(0).setListener(null);
                                                                                                     img1.animate().setListener(null);
                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationCancel(Animator animation) {

                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationRepeat(Animator animation) {

                                                                                                 }
                                                                                             });
                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationCancel(Animator animation) {

                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationRepeat(Animator animation) {

                                                                                         }
                                                                                     }

            );
        } else {
            img2.setImageURI(uri);
            img2.animate().alpha(0).setDuration(0).setListener(null);
            img2.setX(0);
            img2.setY(0);
            img2.setRotationX(270);
            img1.setX(0);
            img1.setY(0);
            img1.setRotationX(0);
            img1.animate().rotationX(90).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                         @Override
                                                                                         public void onAnimationStart(Animator animation) {
                                                                                             img2.animate().alpha(1).setListener(null);
                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationEnd(Animator animation) {
                                                                                             img1.animate().alpha(0).rotationX(0).setDuration(0).setListener(null);
                                                                                             img2.animate().rotationX(360).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                                 @Override
                                                                                                 public void onAnimationStart(Animator animation) {
                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationEnd(Animator animation) {
                                                                                                     timer();
//                                                                                       img2.animate().rotationX(0).setListener(null);
                                                                                                     img2.animate().setListener(null);
                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationCancel(Animator animation) {

                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationRepeat(Animator animation) {

                                                                                                 }
                                                                                             });
                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationCancel(Animator animation) {

                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationRepeat(Animator animation) {

                                                                                         }
                                                                                     }

            );
        }

    }

    /**
     * Flip down animation
     *
     * @param uri - image uri to change
     */
    private void flipDownAnimation(final Uri uri) {
        if (counter % 2 == 0) {
            img1.setImageURI(uri);
            img1.animate().alpha(0).setDuration(0).setListener(null);
            img1.setX(0);
            img1.setY(0);
            img1.setRotationX(-270);
            img2.setX(0);
            img2.setY(0);
            img2.setRotationX(0);
            img2.animate().rotationX(-90).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                          @Override
                                                                                          public void onAnimationStart(Animator animation) {
                                                                                              img1.animate().alpha(1).setListener(null);
                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationEnd(Animator animation) {
                                                                                              img2.animate().alpha(0).rotationX(0).setDuration(0).setListener(null);
                                                                                              img1.animate().rotationX(-360).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                                  @Override
                                                                                                  public void onAnimationStart(Animator animation) {
                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationEnd(Animator animation) {
                                                                                                      timer();
//                                                                                           img1.animate().rotationX(0).setListener(null);
                                                                                                      img1.animate().setListener(null);
                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationCancel(Animator animation) {

                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationRepeat(Animator animation) {

                                                                                                  }
                                                                                              });
                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationCancel(Animator animation) {

                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationRepeat(Animator animation) {

                                                                                          }
                                                                                      }

            );
        } else {
            img2.setImageURI(uri);
            img2.animate().alpha(0).setDuration(0).setListener(null);
            img2.setX(0);
            img2.setY(0);
            img2.setRotationX(-270);
            img1.setX(0);
            img1.setY(0);
            img1.setRotationX(0);
            img1.animate().rotationX(-90).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                          @Override
                                                                                          public void onAnimationStart(Animator animation) {
                                                                                              img2.animate().alpha(1).setListener(null);
                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationEnd(Animator animation) {
                                                                                              img1.animate().alpha(0).rotationX(0).setDuration(0).setListener(null);
                                                                                              img2.animate().rotationX(-360).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                                  @Override
                                                                                                  public void onAnimationStart(Animator animation) {
                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationEnd(Animator animation) {
                                                                                                      timer();
//                                                                                       img2.animate().rotationX(0).setListener(null);
                                                                                                      img2.animate().setListener(null);
                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationCancel(Animator animation) {

                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationRepeat(Animator animation) {

                                                                                                  }
                                                                                              });
                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationCancel(Animator animation) {

                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationRepeat(Animator animation) {

                                                                                          }
                                                                                      }

            );
        }

    }

    /**
     * Flip left animation
     *
     * @param uri - image uri to change
     */
    private void flipLeftAnimation(final Uri uri) {
        if (counter % 2 == 0) {
            img1.setImageURI(uri);
            img1.animate().alpha(0).setDuration(0).setListener(null);
            img1.setX(0);
            img1.setY(0);
            img1.setRotationY(-270);
            img2.setX(0);
            img2.setY(0);
            img2.setRotationY(0);
            img2.animate().rotationY(-90).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                          @Override
                                                                                          public void onAnimationStart(Animator animation) {
                                                                                              img1.animate().alpha(1).setListener(null);
                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationEnd(Animator animation) {
                                                                                              img2.animate().alpha(0).rotationY(0).setDuration(0).setListener(null);
                                                                                              img1.animate().rotationY(-360).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                                  @Override
                                                                                                  public void onAnimationStart(Animator animation) {
                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationEnd(Animator animation) {
                                                                                                      timer();
//                                                                                           img1.animate().rotationX(0).setListener(null);
                                                                                                      img1.animate().setListener(null);
                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationCancel(Animator animation) {

                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationRepeat(Animator animation) {

                                                                                                  }
                                                                                              });
                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationCancel(Animator animation) {

                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationRepeat(Animator animation) {

                                                                                          }
                                                                                      }

            );
        } else {
            img2.setImageURI(uri);
            img2.animate().alpha(0).setDuration(0).setListener(null);
            img2.setX(0);
            img2.setY(0);
            img2.setRotationY(-270);
            img1.setX(0);
            img1.setY(0);
            img1.setRotationY(0);
            img1.animate().rotationY(-90).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                          @Override
                                                                                          public void onAnimationStart(Animator animation) {
                                                                                              img2.animate().alpha(1).setListener(null);
                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationEnd(Animator animation) {
                                                                                              img1.animate().alpha(0).rotationY(0).setDuration(0).setListener(null);
                                                                                              img2.animate().rotationY(-360).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                                  @Override
                                                                                                  public void onAnimationStart(Animator animation) {
                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationEnd(Animator animation) {
                                                                                                      timer();
//                                                                                       img2.animate().rotationX(0).setListener(null);
                                                                                                      img2.animate().setListener(null);
                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationCancel(Animator animation) {

                                                                                                  }

                                                                                                  @Override
                                                                                                  public void onAnimationRepeat(Animator animation) {

                                                                                                  }
                                                                                              });
                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationCancel(Animator animation) {

                                                                                          }

                                                                                          @Override
                                                                                          public void onAnimationRepeat(Animator animation) {

                                                                                          }
                                                                                      }

            );
        }
    }

    /**
     * Flip right animation
     *
     * @param uri - image uri to change
     */
    private void flipRightAnimation(final Uri uri) {
        if (counter % 2 == 0) {
            img1.setImageURI(uri);
            img1.animate().alpha(0).setDuration(0).setListener(null);
            img1.setX(0);
            img1.setY(0);
            img1.setRotationY(270);
            img2.setX(0);
            img2.setY(0);
            img2.setRotationY(0);
            img2.animate().rotationY(90).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                         @Override
                                                                                         public void onAnimationStart(Animator animation) {
                                                                                             img1.animate().alpha(1).setListener(null);
                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationEnd(Animator animation) {
                                                                                             img2.animate().alpha(0).rotationY(0).setDuration(0).setListener(null);
                                                                                             img1.animate().rotationY(360).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                                 @Override
                                                                                                 public void onAnimationStart(Animator animation) {
                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationEnd(Animator animation) {
                                                                                                     timer();
//                                                                                           img1.animate().rotationX(0).setListener(null);
                                                                                                     img1.animate().setListener(null);
                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationCancel(Animator animation) {

                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationRepeat(Animator animation) {

                                                                                                 }
                                                                                             });
                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationCancel(Animator animation) {

                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationRepeat(Animator animation) {

                                                                                         }
                                                                                     }

            );
        } else {
            img2.setImageURI(uri);
            img2.animate().alpha(0).setDuration(0).setListener(null);
            img2.setX(0);
            img2.setY(0);
            img2.setRotationY(270);
            img1.setX(0);
            img1.setY(0);
            img1.setRotationY(0);
            img1.animate().rotationY(90).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                         @Override
                                                                                         public void onAnimationStart(Animator animation) {
                                                                                             img2.animate().alpha(1).setListener(null);
                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationEnd(Animator animation) {
                                                                                             img1.animate().alpha(0).rotationY(0).setDuration(0).setListener(null);
                                                                                             img2.animate().rotationY(360).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                                                                                                 @Override
                                                                                                 public void onAnimationStart(Animator animation) {
                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationEnd(Animator animation) {
                                                                                                     timer();
//                                                                                       img2.animate().rotationX(0).setListener(null);
                                                                                                     img2.animate().setListener(null);
                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationCancel(Animator animation) {

                                                                                                 }

                                                                                                 @Override
                                                                                                 public void onAnimationRepeat(Animator animation) {

                                                                                                 }
                                                                                             });
                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationCancel(Animator animation) {

                                                                                         }

                                                                                         @Override
                                                                                         public void onAnimationRepeat(Animator animation) {

                                                                                         }
                                                                                     }

            );
        }
    }

    /**
     * Alpha from 0 to 1 and back to 1 animation
     *
     * @param uri - image uri to change
     */
    private void alphaAnimation(final Uri uri) {
        if (counter % 2 == 0) {
            Log.i("i is", "even " + String.valueOf(counter));
            img1.animate().alpha(0).setDuration(0).setListener(null);
            img1.setImageURI(uri);
            img1.setX(0);
            img1.setY(0);
            img2.animate().alpha(0.0f).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    img1.animate().alpha(1.0f).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            timer();
                            img1.animate().setListener(null);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    img2.animate().setListener(null);

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        } else {
            Log.i("i is", "odd " + String.valueOf(counter));
            img2.animate().alpha(0).setDuration(0).setListener(null);
            img2.setImageURI(uri);
            img2.setX(0);
            img2.setY(0);
            img1.animate().alpha(0.0f).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    img2.animate().alpha(1.0f).setDuration(animationSpeed / 2).setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            timer();
                            img2.animate().setListener(null);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    img1.animate().setListener(null);

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }


    }

    /**
     * SlideRight animation
     *
     * @param uri - image uri to change
     */
    private void slideRight(final Uri uri) {
        if (counter % 2 == 0) {
            Log.i("counter is", "even " + String.valueOf(counter));
            img1.setImageURI(uri);
            //img2.animate().alpha(0).setDuration(0).setListener(null);
            //img2.setX(0);
            img1.setX(-img1.getWidth());
            img1.setY(0);
            img1.animate().alpha(1).setListener(null);
            img2.animate().x(img2.getWidth()).setDuration(2000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    //img2.animate().alpha(1).setDuration(0).setListener(null);
                    img1.animate().x(0).setDuration(2000).setListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    timer();
                    img2.animate().setListener(null);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        } else {
            Log.i("counter is", "odd " + String.valueOf(counter));
            img2.setImageURI(uri);
            //img2.animate().alpha(0).setDuration(0).setListener(null);
            //img1.setX(0);
            img2.setX(-img2.getWidth());
            img2.setY(0);
            img2.animate().alpha(1).setListener(null);
            img1.animate().x(img1.getWidth()).setDuration(2000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    //img2.animate().alpha(1).setDuration(0).setListener(null);
                    img2.animate().x(0).setDuration(2000).setListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    timer();
                    img1.animate().setListener(null);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
    }

    /**
     * Slide left animation
     *
     * @param uri - image uri to change
     */
    private void slideLeft(final Uri uri) {
        if (counter % 2 == 0) {
            Log.i("counter is", "even " + String.valueOf(counter));
            img1.setImageURI(uri);
            //img2.animate().alpha(0).setDuration(0).setListener(null);
            //img2.setX(0);
            img1.setX(img1.getWidth());
            img1.setY(0);
            img1.animate().alpha(1).setListener(null);
            img2.animate().x(-img2.getWidth()).setDuration(2000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    //img2.animate().alpha(1).setDuration(0).setListener(null);
                    img1.animate().x(0).setDuration(2000).setListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    timer();
                    img2.animate().setListener(null);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        } else {
            Log.i("counter is", "odd " + String.valueOf(counter));
            img2.setImageURI(uri);
            //img2.animate().alpha(0).setDuration(0).setListener(null);
            //img1.setX(0);
            img2.setX(img2.getWidth());
            img2.setY(0);
            img2.animate().alpha(1).setListener(null);
            img1.animate().x(-img1.getWidth()).setDuration(2000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    //img2.animate().alpha(1).setDuration(0).setListener(null);
                    img2.animate().x(0).setDuration(2000).setListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    timer();
                    img1.animate().setListener(null);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
    }

    /**
     * Slide up animation
     *
     * @param uri - image uri to change
     */
    private void slideUp(final Uri uri) {
        if (counter % 2 == 0) {
            Log.i("counter is", "even " + String.valueOf(counter));
            img1.setImageURI(uri);
            //img2.animate().alpha(0).setDuration(0).setListener(null);
            //img2.setX(0);
            img1.setY(-img1.getHeight());
            img1.setX(0);
            img1.animate().alpha(1).setListener(null);
            img2.animate().y(img2.getHeight()).setDuration(2000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    //img2.animate().alpha(1).setDuration(0).setListener(null);
                    img1.animate().y(0).setDuration(2000).setListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    timer();
                    img2.animate().setListener(null);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        } else {
            Log.i("counter is", "odd " + String.valueOf(counter));
            img2.setImageURI(uri);
            //img2.animate().alpha(0).setDuration(0).setListener(null);
            //img1.setX(0);
            img2.setY(-img2.getHeight());
            img2.setX(0);
            img2.animate().alpha(1).setListener(null);
            img1.animate().y(img1.getHeight()).setDuration(2000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    //img2.animate().alpha(1).setDuration(0).setListener(null);
                    img2.animate().y(0).setDuration(2000).setListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    timer();
                    img1.animate().setListener(null);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
    }

    /**
     * Slide down animation
     *
     * @param uri - image uri to change
     */
    private void slideDown(final Uri uri) {
        if (counter % 2 == 0) {
            Log.i("counter is", "even " + String.valueOf(counter));
            img1.setImageURI(uri);
            //img2.animate().alpha(0).setDuration(0).setListener(null);
            //img2.setX(0);
            img1.setY(img1.getHeight());
            img1.setX(0);
            img1.animate().alpha(1).setListener(null);
            img2.animate().y(-img2.getHeight()).setDuration(2000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    //img2.animate().alpha(1).setDuration(0).setListener(null);
                    img1.animate().y(0).setDuration(2000).setListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    timer();
                    img2.animate().setListener(null);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        } else {
            Log.i("counter is", "odd " + String.valueOf(counter));
            img2.setImageURI(uri);
            img2.setY(img2.getWidth());
            img2.setX(0);
            img2.animate().alpha(1).setListener(null);
            img1.animate().y(-img1.getWidth()).setDuration(2000).setListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    //img2.animate().alpha(1).setDuration(0).setListener(null);
                    img2.animate().y(0).setDuration(2000).setListener(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    timer();
                    img1.animate().setListener(null);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
    }

    /**
     * Animation manager check if images urls exists ans start the timer.
     */
    public void animationManager() {
        if (imagesUrls.size() > 0) {
            img1.setImageURI(imagesUrls.get(0));
            timer();
        }
    }

    /**
     * Every 3 seconds random animation
     */
    public void timer() {
        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                if (i >= imagesUrls.size())
                    i = 0;

                int n = rand.nextInt(animationsToUse.size());
                switch (animationsToUse.get(n)) {
                    case Defaults.FLIP_UP:
                        flipUpAnimation(imagesUrls.get(i));
                        break;
                    case Defaults.FLIP_DOWN:
                        flipDownAnimation(imagesUrls.get(i));
                        break;
                    case Defaults.FADE:
                        alphaAnimation(imagesUrls.get(i));
                        break;
                    case Defaults.SLIDE_RIGHT:
                        slideRight(imagesUrls.get(i));
                        break;
                    case Defaults.SLIDE_LEFT:
                        slideLeft(imagesUrls.get(i));
                        break;
                    case Defaults.SLIDE_UP:
                        slideUp(imagesUrls.get(i));
                        break;
                    case Defaults.SLIDE_DOWN:
                        slideDown(imagesUrls.get(i));
                        break;
                    case Defaults.FLIP_LEFT:
                        flipLeftAnimation(imagesUrls.get(i));
                        break;
                    case Defaults.FLIP_RIGHT:
                        flipRightAnimation(imagesUrls.get(i));
                        break;
                    default:
                        slideDown(Uri.parse(""));
                        break;
                }
                i++;
                counter++;
            }
        };

        handler.postDelayed(r, startDelay);
    }
}
